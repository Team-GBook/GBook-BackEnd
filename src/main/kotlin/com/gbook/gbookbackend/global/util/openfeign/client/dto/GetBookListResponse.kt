package com.gbook.gbookbackend.global.util.openfeign.client.dto

data class GetBookListResponse (
        val items: List<GetBookResponse>
)
data class GetBookResponse (
        val title: String,
        val author: String,
        val isbn13: String,
        val cover: String,
        val publisher: String
)
