package com.gbook.gbookbackend.global.error

import com.fasterxml.jackson.databind.ObjectMapper
import com.gbook.gbookbackend.global.error.exception.GbookException
import com.gbook.gbookbackend.global.exception.InternalServerError
import org.springframework.http.MediaType
import org.springframework.stereotype.Component
import org.springframework.web.filter.OncePerRequestFilter
import java.nio.charset.StandardCharsets
import javax.servlet.FilterChain
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@Component
class ExceptionFilter(
        private val objectMapper: ObjectMapper
) : OncePerRequestFilter() {
    override fun doFilterInternal(
            request: HttpServletRequest,
            response: HttpServletResponse,
            filterChain: FilterChain,
    ) {
        try {
            filterChain.doFilter(request, response)
        } catch (exception: Exception) {
            exception.printStackTrace()
            when (exception) {
                is GbookException -> writeErrorCode(exception, response)
                else -> writeErrorCode(InternalServerError, response)
            }
        }
    }

    private fun writeErrorCode(exception: GbookException, response: HttpServletResponse) {
        val errorResponse = ErrorResponse.of(exception)
        response.apply {
            status = errorResponse.status
            characterEncoding = StandardCharsets.UTF_8.name()
            contentType = MediaType.APPLICATION_JSON_VALUE
            writer.write(objectMapper.writeValueAsString(errorResponse))
        }
    }
}