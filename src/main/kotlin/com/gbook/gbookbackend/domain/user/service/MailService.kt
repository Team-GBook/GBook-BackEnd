package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.exception.AlreadyCheckedMailException
import com.gbook.gbookbackend.domain.user.exception.InvalidCodeException
import com.gbook.gbookbackend.domain.user.facade.MailFacade
import com.gbook.gbookbackend.global.util.ses.MailUtil
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MailService(
    private val mailUtil: MailUtil,
    private val mailFacade: MailFacade
) {
    @Transactional
    fun send(email: String) {
        mailUtil.sendMail(email)
    }

    @Transactional
    fun check(email: String, code: Int) {
        val mail = mailFacade.getByMail(email)

        if (mail.isChecked) {
            throw AlreadyCheckedMailException
        }

        if (code != mail.code) {
            throw InvalidCodeException
        }

        mail.updateIsChecked(true)
    }
}