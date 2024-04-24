package com.gbook.gbookbackend.domain.user.facade

import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.domain.user.domain.repository.UserRepository
import com.gbook.gbookbackend.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val email: String = SecurityContextHolder.getContext().authentication.name
        return getByEmail(email)
    }
    fun checkUserExist(email: String): Boolean {
        return userRepository.existsByEmail(email)
    }
    fun getByEmail(email: String): User {
        return userRepository.findByEmail(email)?: throw UserNotFoundException
    }
}