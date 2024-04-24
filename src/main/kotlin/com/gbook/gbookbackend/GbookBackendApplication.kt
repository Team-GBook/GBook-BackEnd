package com.gbook.gbookbackend

import com.gbook.gbookbackend.global.security.jwt.JwtProperties
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.boot.runApplication
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity

@EnableConfigurationProperties(JwtProperties::class)
@SpringBootApplication
class GbookBackendApplication

fun main(args: Array<String>) {
    runApplication<GbookBackendApplication>(*args)
}
