package com.gbook.gbookbackend.domain.review.presentation.dto.response

import java.util.UUID

data class QueryReplyListResponse(
    val replies: List<ReplyElement>
)

data class ReplyElement(
    val id: UUID,
    val username: String,
    val content: String
)