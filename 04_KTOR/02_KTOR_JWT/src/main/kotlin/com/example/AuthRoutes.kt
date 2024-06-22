package com.example

import com.example.authenticate
import com.example.data.requests.AuthRequest
import com.example.data.responces.AuthResponce
import com.example.data.users.User
import com.example.data.users.UserDataSource
import com.example.security.hashing.HashingService
import com.example.security.hashing.SaltedHash
import com.example.security.token.TokenClaim
import com.example.security.token.TokenConfig
import com.example.security.token.TokenService
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*

fun Route.signUp(
    hashingService: HashingService,
    userDataSource: UserDataSource
) {
    post("signup") {
        // User provided Bad Auth Request
        val request = call.receiveOrNull<AuthRequest>() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        // Credential Validation
        val areFieldsBlank = request.username.isBlank() || request.password.isBlank()
        val isPwTooShort = request.password.length < 5
        if(areFieldsBlank || isPwTooShort) {
            call.respond(HttpStatusCode.Conflict)
            return@post
        }

        // Proceeding for hashing...
        val saltedHash = hashingService.generateSaltedHash(request.password)
        // Saving Credential in DB...
        val user = User(
            username = request.username,
            password = saltedHash.hash,
            salt = saltedHash.salt
        )
        val wasAcknowledge = userDataSource.insertUser(user)
        if(!wasAcknowledge){
            call.respond(HttpStatusCode.Conflict)
            return@post
        }
        call.respond(HttpStatusCode.OK)
    }
}

fun Route.signIn(
    userDataSource: UserDataSource,
    hashingService: HashingService,
    tokenService: TokenService,
    tokenConfig: TokenConfig
) {
    post("signin") {
        val request = call.receiveOrNull<AuthRequest>() ?: kotlin.run {
            call.respond(HttpStatusCode.BadRequest)
            return@post
        }
        val user = userDataSource.getUserByUsername(request.username)
        if(user == null){
            call.respond(HttpStatusCode.Conflict,"Incorrect Username Or Password :CODE 01")
            return@post
        }
        val isValidPassword = hashingService.verify(
            value = request.password,
            saltedHash = SaltedHash(
                hash = user.password,
                salt = user.salt
            )
        )
        if(!isValidPassword){
            call.respond(HttpStatusCode.Conflict,"Incorrect Username Or Password :CODE 02")

            println("Provided Password: ${request.password}")
            println("Hashed Password: ${user.password}")
            println("Salt: ${user.salt}")
            println("Verification Result: $isValidPassword")

            return@post
        }

        // Sign in successful now generating token
        val token = tokenService.generate(
            config = tokenConfig,
            TokenClaim(
                name = "userId",
                value = user.id.toString()
            )
        )
        call.respond(
            status = HttpStatusCode.OK,
            message = AuthResponce(
                token = token
            )
        )
    }
}

// For User Persistence...
fun Route.authenticate() {
    authenticate {
        get("authenticate") {
            call.respond(HttpStatusCode.OK)
        }
    }
}

fun Route.getSecretInfo() {
    authenticate {
        get("secret") {
            val principal = call.principal<JWTPrincipal>()
            val userId = principal?.getClaim("userId", String::class)
            call.respond(HttpStatusCode.OK,"Your User Id is : $userId")
        }
    }
}