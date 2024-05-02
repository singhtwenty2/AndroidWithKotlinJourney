package com.example

import com.example.data.users.MongoService
import com.example.data.users.Student
import com.example.plugins.*
import io.ktor.server.application.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import org.litote.kmongo.coroutine.coroutine
import org.litote.kmongo.reactivestreams.KMongo

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    val mongoPw = System.getenv("MONGO_PASS")
    val dbName = "students-db"
    val db = KMongo.createClient(
        connectionString = "mongodb+srv://trm97713:$mongoPw@cluster0.0issq55.mongodb.net/$dbName?retryWrites=true&w=majority"
    ).coroutine
        .getDatabase(dbName)
    val studentDataSource = MongoService(db)
//    GlobalScope.launch {
//        val student = Student(
//            name = "Ranjan-Kumar-Verma",
//            usn = "1ST21CS171",
//            dob = "17-06-2002",
//            phoneNumber = 9876543210
//        )
//        studentDataSource.insertNewStudent(student)
//    }

    configureSerialization()
    configureMonitoring()
    configureRouting()
}
