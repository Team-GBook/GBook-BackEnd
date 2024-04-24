package com.gbook.gbookbackend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    PASSWORD_MISMATCED(400, "Password Mis Matched"),
    INVALID_CODE(400, "Invalid Code"),
    INVALID_MAIL(400, "Invalid Mail"),

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    NOT_FOUND_MAIL(404, "Not Found Mail"),
    NOT_FOUND_USER(404, "Not Found User"),

    ALREADY_USER(409, "Already User"),
    ALREADY_CHECKED_MAIL(409, "Already Checked Mail"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}