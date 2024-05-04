package com.gbook.gbookbackend.global.util.openfeign.client.dto

data class GetBookListResponse(
    val item: List<GetBookResponse>
)

data class GetBookResponse(
    val title: String,
    val author: String,
    val isbn: String,
    val cover: String,
    val publisher: String
)
