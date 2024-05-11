package com.gbook.gbookbackend.domain.user.presentation.dto.response

import com.gbook.gbookbackend.domain.user.domain.Genre

data class QueryUserInfoResponse(
    val email: String,
    val nickName: String,
    val genre: Genre,
    val profile: String
)