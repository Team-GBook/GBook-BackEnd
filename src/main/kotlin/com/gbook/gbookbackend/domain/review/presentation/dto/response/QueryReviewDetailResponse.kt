package com.gbook.gbookbackend.domain.review.presentation.dto.response

import java.time.LocalDate
import java.util.UUID

data class QueryReviewDetailResponse(
    val id: UUID
    val isbn: String,
    val title: String,
    val user: String,
    val review: String,
    val reconstruction: String,
    val analysis: String,
    val isMine: Boolean,
    val createdAt: LocalDate,
)
