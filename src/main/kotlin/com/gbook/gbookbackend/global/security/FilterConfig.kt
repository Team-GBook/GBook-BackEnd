package com.gbook.gbookbackend.global.security

import com.fasterxml.jackson.databind.ObjectMapper
import com.gbook.gbookbackend.global.error.ExceptionFilter
import org.springframework.security.config.annotation.SecurityConfigurerAdapter
import org.springframework.security.config.annotation.web.builders.HttpSecurity
import org.springframework.security.web.DefaultSecurityFilterChain
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter

class FilterConfig(
    private val objectMapper: ObjectMapper
) : SecurityConfigurerAdapter<DefaultSecurityFilterChain, HttpSecurity>() {
    override fun configure(builder: HttpSecurity) {
        val exceptionFilter = ExceptionFilter(objectMapper)
        builder.addFilterBefore(exceptionFilter, UsernamePasswordAuthenticationFilter::class.java)
    }
}