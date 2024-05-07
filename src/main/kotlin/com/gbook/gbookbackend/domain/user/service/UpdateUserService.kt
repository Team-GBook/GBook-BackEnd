package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.domain.repository.UserRepository
import com.gbook.gbookbackend.domain.user.exception.AlreadyUserException
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.domain.user.presentation.dto.request.UpdateUserRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository
) {
    @Transactional
    fun execute(request: UpdateUserRequest) {
        val user = userFacade.getCurrentUser()
        if (userRepository.existsByNickName(request.nickName)) {
            throw AlreadyUserException
        }
        user.updateUserInfo(request.nickName, request.genre)
    }
}