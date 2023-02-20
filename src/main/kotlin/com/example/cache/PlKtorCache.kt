package com.example.cache

import com.example.user.model.registr.RegistrationReceiveRemote

object PlKtorCache {
    val userList: MutableList<RegistrationReceiveRemote> = mutableListOf()
    val token: MutableList<TokenPlCache> = mutableListOf()
}

data class TokenPlCache(
    val loginId: String,
    val token: String
)

