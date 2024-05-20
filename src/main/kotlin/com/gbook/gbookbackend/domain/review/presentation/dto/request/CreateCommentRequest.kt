package com.gbook.gbookbackend.domain.review.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateCommentRequest(
    @field:NotBlank(message = "content는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 1000, message = "content은 1000자 이하여야 합니다.")
    val content: String,
)
