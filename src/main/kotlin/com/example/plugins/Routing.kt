@file:Suppress("UNUSED_EXPRESSION")

package com.example.plugins

import com.example.user.model.auth.LoginRemote
import io.ktor.http.*
import io.ktor.server.application.*
import io.ktor.server.request.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import io.ktor.util.*


fun Application.configureRouting() {

    routing {


        get("/") {

            println("Headers: ${(call.request.headers.names())}")
            println("User-Agent: ${(call.request.headers["User-Agent"])}")
            println("Accept: ${(call.request.headers["Accept"])}")
            println("Query Params: ${(call.request.queryParameters.names())}")
            println("Name: ${(call.request.queryParameters["name"])}")
            println("Email: ${(call.request.queryParameters["email"])}")
            println("Age: ${(call.request.queryParameters["age"])}")
            call.respondText("Hello ktor \n${call.request.headers}", status = HttpStatusCode.GatewayTimeout)
        }
        get("/usersimages/{page}") {
            val pageNumber = call.parameters["page"]
            call.respondText("Response -> $pageNumber")
        }
        post("/login") {
            val userLogin = LoginRemote("Shahzod", "Shahzod12345")
            call.response.headers.append("server-name", "Shahzod header...")
            call.respond(userLogin.toString())
        }
        get("/resume") {
            //val file = File("file/shahzod_cv.pdf")
            call.response.header(
                HttpHeaders.ContentDisposition, ContentDisposition.Attachment.withParameter(
                    ContentDisposition.Parameters.FileName, "downloadsv.pdf"
                ).toString()
            )
            call.respondText("File downloading...")
        }
    }
}
