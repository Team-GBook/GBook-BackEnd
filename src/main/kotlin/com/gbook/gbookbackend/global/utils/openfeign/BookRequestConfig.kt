package com.gbook.gbookbackend.global.utils.openfeign

import feign.RequestInterceptor
import feign.RequestTemplate
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BookRequestConfig(
    @Value("\${aladin.api-key}") val apiKey: String
) {
    @Bean
    fun requestInterceptor(): RequestInterceptor {
        return RequestInterceptor { template: RequestTemplate ->
            template.query("TTBKey", apiKey)
            template.query("output", "js")
        }
    }
}