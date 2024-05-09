package com.aryan

import com.aryan.plugins.*
import io.ktor.server.application.*

fun main(args: Array<String>) {
    io.ktor.server.netty.EngineMain.main(args)
}

fun Application.module() {
    
    configureSecurity()
    configureSockets()
    configureSerialization()
    configureMonitoring()
    configureHTTP()
    configureRouting()
}
