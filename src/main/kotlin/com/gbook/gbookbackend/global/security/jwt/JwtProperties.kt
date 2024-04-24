package com.gbook.gbookbackend.global.security.jwt

import org.springframework.boot.context.properties.ConfigurationProperties
import org.springframework.boot.context.properties.ConstructorBinding

@ConstructorBinding
@ConfigurationProperties(prefix = "jwt")
data class JwtProperties(
    var secretKey: String,
    val accessExp: Long,
    val refreshExp: Long
)