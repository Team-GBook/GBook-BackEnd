package com.gbook.gbookbackend.domain.review.presentation.dto.response

import java.util.UUID

data class QueryCommentListResponse(
    val comments: List<CommentElement>
)

data class CommentElement(
    val id: UUID,
    val username: String,
    val content: String,
    val replyCount: Int
)