package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.exception.PasswordMisMatchedException
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.domain.user.presentation.dto.request.UserLoginRequest
import com.gbook.gbookbackend.domain.user.presentation.dto.response.TokenResponse
import com.gbook.gbookbackend.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserLoginService(
        val userFacade: UserFacade,
        val passwordEncoder: PasswordEncoder,
        val tokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(request: UserLoginRequest) : TokenResponse {
        val user = userFacade.getByEmail(request.email)
        if (!passwordEncoder.matches(request.password, user.password)){
            throw PasswordMisMatchedException
        }

        return tokenProvider.getToken(user.email)
    }
}