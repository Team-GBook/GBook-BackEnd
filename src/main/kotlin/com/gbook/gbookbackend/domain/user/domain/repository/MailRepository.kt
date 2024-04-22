package com.gbook.gbookbackend.domain.user.domain.repository

import com.gbook.gbookbackend.domain.user.domain.Mail
import org.springframework.data.repository.CrudRepository
import java.util.UUID

interface MailRepository: CrudRepository<Mail, UUID> {
    fun existsByEmail(email: String): Boolean
    fun findByEmail(email: String): Mail?
}