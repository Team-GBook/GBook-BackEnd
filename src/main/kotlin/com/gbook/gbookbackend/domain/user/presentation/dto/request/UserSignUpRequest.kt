package com.gbook.gbookbackend.domain.user.presentation.dto.request

import com.gbook.gbookbackend.domain.user.domain.Genre
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class UserSignUpRequest(
    @field:NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Pattern(
        regexp = "[0-9a-zA-Z]+(.[_a-z0-9-]+)*@(?:\\w+\\.)+\\w+$",
        message = "이메일 형식에 맞지 않습니다."
    )
    var email: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Pattern(
        regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" + "?@]{8,20}$",
        message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다."
    )
    var password: String,

    @field:NotBlank(message = "nick_name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 15, message = "nick_name은 15자 이하여야 합니다.")
    var nickName: String,

    @field:NotNull(message = "genre는 Null를 허용하지 않습니다.")
    val genre: Genre
)