package com.gbook.gbookbackend.domain.user.presentation.dto.request

import com.gbook.gbookbackend.domain.user.domain.Genre
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class UpdateUserRequest(
    @field:NotBlank(message = "nick_name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 15, message = "nick_name은 15자 이하여야 합니다.")
    var nickName: String,

    @field:NotNull(message = "genre는 Null를 허용하지 않습니다.")
    var genre: Genre
)