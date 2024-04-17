package com.gbook.gbookbackend.domain.user.presentation.dto

import com.gbook.gbookbackend.domain.user.domain.Genre
import javax.validation.constraints.NotBlank
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class UserSignUpRequest(
        @field:NotBlank(message = "email는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
        @field:Size(min = 5, max = 15, message = "email는 5자 이상 15자 이하여야 합니다.")
        @field:Pattern(
                regexp = "^[a-zA-Z0-9]+@[a-zA-Z0-9]+\$",
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
        @field:Size(max = 5, message = "nick_name은 15자 이하여야 합니다.")
        var nickName: String,

        @field:NotBlank(message = "genre는 Null를 허용하지 않습니다.")
        var genre: Genre
)