package com.example.user.model.user

import kotlinx.serialization.Serializable

@Serializable
data class UserRemoteModel(val name: String, val age: Int)
