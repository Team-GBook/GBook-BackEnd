package com.gbook.gbookbackend.domain.review.presentation.dto.response

import java.time.LocalDate
data class QueryReviewDetailResponse(
    val isbn: String,
    val title: String,
    val user: String,
    val review: String,
    val reconstruction: String,
    val analysis: String,
    val isMine: Boolean,
    val createdAt: LocalDate,
)
