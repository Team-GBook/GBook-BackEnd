package com.gbook.gbookbackend.domain.user.facade

import com.gbook.gbookbackend.domain.user.domain.Mail
import com.gbook.gbookbackend.domain.user.domain.repository.MailRepository
import com.gbook.gbookbackend.domain.user.exception.MailNotFoundException
import org.springframework.stereotype.Component

@Component
class MailFacade(
    private val mailRepository: MailRepository
) {
    fun getByMail(email: String): Mail {
        return mailRepository.findByEmail(email) ?: throw MailNotFoundException
    }
}