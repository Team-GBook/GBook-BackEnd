package com.gbook.gbookbackend.domain.review.presentation.dto.request

import com.gbook.gbookbackend.domain.user.domain.Genre
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateReviewRequest(
    @field:NotBlank(message = "review는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 2000, message = "review는 15자 이하여야 합니다.")
    val review: String,

    @field:NotBlank(message = "reconstruction은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 2000, message = "reconstruction은 15자 이하여야 합니다.")
    val reconstruction: String,

    @field:NotBlank(message = "analysis는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 2000, message = "analysis는 15자 이하여야 합니다.")
    val analysis: String,

    @field:NotNull(message = "genre는 Null를 허용하지 않습니다.")
    val genre: Genre,
)
