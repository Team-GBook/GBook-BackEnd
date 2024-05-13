package com.gbook.gbookbackend.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String
) {
    PASSWORD_MIS_MATCHED(400, "Password Mis Matched"),
    INVALID_CODE(400, "Invalid Code"),
    INVALID_MAIL(400, "Invalid Mail"),
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    BAD_FILE_EXTENSION(400,"Bad File Extension"),

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),

    NOT_FOUND_MAIL(404, "Not Found Mail"),
    NOT_FOUND_USER(404, "Not Found User"),
    NOT_FOUND_BOOK(404, "Not Found Book"),
    NOT_FOUND_REVIEW(404, "Not Found Review"),

    ALREADY_USER(409, "Already User"),
    ALREADY_CHECKED_MAIL(409, "Already Checked Mail"),
    ALREADY_REVIEW(409, "Already Review"),

    FEIGN_TOKEN_EXPIRED(419, "Feign Token Expired"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}