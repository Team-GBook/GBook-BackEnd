package com.gbook.gbookbackend.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserLoginRequest(
        @field:NotBlank(message = "emaild는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
        var email: String,

        @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
        var password: String
)