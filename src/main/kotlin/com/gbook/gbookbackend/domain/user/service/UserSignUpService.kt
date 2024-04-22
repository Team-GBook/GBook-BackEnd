package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.domain.user.domain.repository.MailRepository
import com.gbook.gbookbackend.domain.user.domain.repository.UserRepository
import com.gbook.gbookbackend.domain.user.exception.AlreadyUserException
import com.gbook.gbookbackend.domain.user.exception.InvalidMailException
import com.gbook.gbookbackend.domain.user.facade.MailFacade
import com.gbook.gbookbackend.domain.user.presentation.dto.UserSignUpRequest
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder,
    private val mailRepository: MailRepository,
    private val mailFacade: MailFacade,
) {
    fun execute(request: UserSignUpRequest) {
        validUser(request)
        userRepository.save(
            User(
                email = request.email,
                password = passwordEncoder.encode(request.password),
                nickName = request.nickName,
                genre = request.genre,
                profile = ""
            )
        )
    }

    private fun validUser(request: UserSignUpRequest) {
        if (userRepository.existsByEmail(request.email) || userRepository.existsByNickName(request.nickName)) {
            throw AlreadyUserException
        }

        if (!mailRepository.existsByEmail(request.email) || !mailFacade.getByMail(request.email).isChecked) {
            throw InvalidMailException
        }
    }
}