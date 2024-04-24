package com.gbook.gbookbackend.global.security.auth

import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class AuthDetailsService(
    private val userFacade: UserFacade
) : UserDetailsService {
    override fun loadUserByUsername(email: String): UserDetails {
        val user = userFacade.getByEmail(email)
        return AuthDetails(user)
    }
}