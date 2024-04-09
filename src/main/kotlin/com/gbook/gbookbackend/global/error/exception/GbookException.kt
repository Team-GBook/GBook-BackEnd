package com.gbook.gbookbackend.global.error.exception

abstract class GbookException(
        val errorCode: ErrorCode
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message
}