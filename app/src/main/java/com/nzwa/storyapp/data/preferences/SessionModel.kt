package com.nzwa.storyapp.data.preferences

data class SessionModel(
    val name: String,
    val token: String,
    val isLogin: Boolean
)