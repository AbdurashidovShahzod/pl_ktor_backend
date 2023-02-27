package com.example

import com.example.modules.module
import com.example.utils.Const.HOST
import com.example.utils.Const.PORT
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = PORT, host = HOST, module = Application::module).start(wait = true)
}

