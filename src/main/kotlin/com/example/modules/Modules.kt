package com.example.modules

import com.example.plugins.configSerialization
import com.example.plugins.configureHTTP
import com.example.plugins.configureRouting
import io.ktor.server.application.*

fun Application.module() {
    configureHTTP()
    configureRouting()
    configSerialization()
}
