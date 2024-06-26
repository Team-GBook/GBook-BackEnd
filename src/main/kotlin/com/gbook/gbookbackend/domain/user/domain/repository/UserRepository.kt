package com.gbook.gbookbackend.domain.user.domain.repository

import com.gbook.gbookbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface UserRepository : JpaRepository<User, UUID> {
    fun existsByEmail(email: String): Boolean
    fun existsByNickName(nickName: String): Boolean
    fun findByEmail(email: String): User?
}