package com.gbook.gbookbackend.global.error

import com.gbook.gbookbackend.global.error.exception.GbookException

class ErrorResponse(
        val status: Int,
        val message: String,
) {
    companion object {
        fun of(e: GbookException): ErrorResponse {
            return ErrorResponse(
                    status = e.status,
                    message = e.message
            )
        }
    }
}