@file:Suppress("UNUSED_EXPRESSION")

package com.example.plugins

import com.example.user.model.user.UserRemoteModel
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*

fun Application.configureRouting() {
    routing {
        get("/users") {
            val listUserRemoteModel = mutableListOf<UserRemoteModel>()
            listUserRemoteModel.add(UserRemoteModel("Shahzod1", 23))
            listUserRemoteModel.add(UserRemoteModel("Shahzod2", 24))
            listUserRemoteModel.add(UserRemoteModel("Shahzod3", 25))
            listUserRemoteModel.add(UserRemoteModel("Shahzod4", 26))
            call.respond(listUserRemoteModel)
        }
    }
}

