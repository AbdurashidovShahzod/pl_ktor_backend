@file:Suppress("UNUSED_EXPRESSION")

package com.example.plugins

import com.example.user.model.auth.LoginRemote
import com.example.user.model.user.UserRemoteModel
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import kotlin.math.log

fun Application.configureRouting() {

    routing {


        get("/") {
            call.respondText("Hello ktor \n${call.request.headers}")
            println("Headers: ${(call.request.headers.names())}")
            println("User-Agent: ${(call.request.headers["User-Agent"])}")
            println("Accept: ${(call.request.headers["Accept"])}")
            println("Query Params: ${(call.request.queryParameters.names())}")
            println("Name: ${(call.request.queryParameters["name"])}")
            println("Email: ${(call.request.queryParameters["email"])}")
            println("Age: ${(call.request.queryParameters["age"])}")
        }
        get("/usersimages/{page}") {
            val pageNumber = call.parameters["page"]
            call.respondText("Response -> $pageNumber")
        }
        post("/login") {
            val loginRemote = call.receive<LoginRemote>()
            println(loginRemote.login)
            call.respondText("Login...")
        }
    }
}
