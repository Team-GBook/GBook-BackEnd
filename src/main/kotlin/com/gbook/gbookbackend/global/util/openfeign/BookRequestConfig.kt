package com.gbook.gbookbackend.global.util.openfeign

import feign.RequestInterceptor
import feign.RequestTemplate
import feign.codec.Decoder
import org.springframework.beans.factory.annotation.Value
import org.springframework.cloud.openfeign.support.ResponseEntityDecoder
import org.springframework.cloud.openfeign.support.SpringDecoder
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.http.HttpHeaders
import org.springframework.http.HttpInputMessage
import org.springframework.http.MediaType
import org.springframework.http.converter.HttpMessageConverter
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter
import java.io.InputStreamReader
import java.lang.reflect.Type

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