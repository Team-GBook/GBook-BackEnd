package com.gbook.gbookbackend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    ALREADY_USER(409, "Already User"),
    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}