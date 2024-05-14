package com.gbook.gbookbackend.domain.review.presentation.dto.response

import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.user.domain.Genre

data class QueryReviewListResponse(
    val reviewList: List<QueryReviewResponse>
)

data class QueryReviewResponse(
    val isbn: String,
    val review: String,
    val reconstruction: String,
    val analysis: String,
    val genre: Genre,
    val isMine: Boolean
)