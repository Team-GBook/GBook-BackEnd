package com.gbook.gbookbackend.domain.review.presentation.dto.response

import java.time.LocalDate
import java.util.UUID

data class QueryReviewListResponse(
    val reviewList: List<QueryReviewResponse>
)

data class QueryReviewResponse(
    val id: UUID,
    val isbn: String,
    val title: String,
    val user: String,
    val isMine: Boolean,
    val createdAt: LocalDate,
    val likeCount: Int,
    val commentCount: Int
)