@file:Suppress("UNUSED_EXPRESSION")

package com.example.user.model.auth

import com.example.cache.PlKtorCache
import com.example.cache.TokenPlCache
import com.example.user.model.user.UserRemoteModel
import io.ktor.server.routing.*
import io.ktor.server.response.*
import io.ktor.server.application.*
import io.ktor.server.request.*

fun Application.configureRouting() {
    routing {
        get("/login") {
            val receive = call.receive(LoginRemote::class)
            if (PlKtorCache.userList.map {
                    it.login
                }.contains(receive.login)){
                val token = (UUID)
                PlKtorCache.token.add(TokenPlCache(loginId = receive.login, token = receive.password))
            }
        }
    }
}

