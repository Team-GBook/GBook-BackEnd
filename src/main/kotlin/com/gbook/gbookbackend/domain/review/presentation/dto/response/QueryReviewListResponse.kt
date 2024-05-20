package com.gbook.gbookbackend.domain.review.presentation.dto.response

import com.gbook.gbookbackend.domain.user.domain.Genre
import java.time.LocalDate

data class QueryReviewListResponse(
    val reviewList: List<QueryReviewResponse>
)

data class QueryReviewResponse(
    val isbn: String,
    val title: String,
    val user: String,
    val isMine: Boolean,
    val createdAt: LocalDate,
    val likeCount: Int,
    val commentCount: Int
)