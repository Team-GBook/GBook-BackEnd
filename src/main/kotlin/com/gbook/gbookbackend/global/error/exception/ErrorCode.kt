package com.gbook.gbookbackend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    INVALID_CODE(400, "Invalid Code"),

    NOT_FOUND_MAIL(404, "Not Found Mail"),

    ALREADY_USER(409, "Already User"),
    ALREADY_CHECKED_MAIL(409, "Already Checked Mail"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}