package com.gbook.gbookbackend.global.utils.openfeign.client.dto

data class GetAladinBookListResponse(
    val totalResults: Int,
    val item: List<AladinBookElement>
)

data class AladinBookElement(
    val title: String,
    val author: String,
    val isbn: String,
    val cover: String,
    val publisher: String
)
