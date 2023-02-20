package com.example.user.model.auth

import kotlinx.serialization.Serializable

@Serializable
data class LoginRemote(
    val login: String, val password: String
)

@Serializable
data class LoginResponse(
    val token: String
)