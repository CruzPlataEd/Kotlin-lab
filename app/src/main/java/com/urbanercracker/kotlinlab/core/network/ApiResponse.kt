package com.urbanercracker.kotlinlab.core.network

data class ApiResponse<T>(
    val status: Boolean,
    val message: String,
    val code: Int,
    val data: T?
)