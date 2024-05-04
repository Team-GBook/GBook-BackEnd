package com.gbook.gbookbackend.domain.book.presentation.dto.response

data class GetBookListResponse(
    val totalPage: Int,
    val items: List<BookElement>
)

data class BookElement(
    val title: String,
    val author: String,
    val isbn: String,
    val cover: String,
    val publisher: String,
    val reviewCount: Int,
    val likeCount:Int,
    val isLiked: Boolean,
)
