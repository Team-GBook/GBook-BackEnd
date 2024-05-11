package com.gbook.gbookbackend.global.utils.aws.ses

import com.gbook.gbookbackend.domain.user.domain.Mail
import com.gbook.gbookbackend.domain.user.domain.repository.MailRepository
import com.gbook.gbookbackend.domain.user.facade.MailFacade
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.mail.javamail.MimeMessageHelper
import org.springframework.stereotype.Component
import java.security.SecureRandom

@Component
class MailUtil(
    private val javaMailSender: JavaMailSender,
    private val mailRepository: MailRepository,
    private val mailFacade: MailFacade
) {
    fun sendMail(email: String) {
        val code = createRandomNumber()
        val message = javaMailSender.createMimeMessage()
        val helper = MimeMessageHelper(message)

        helper.setTo(email)
        helper.setSubject("공북 이메일 인증")
        helper.setText("인증 코드 : $code")
        helper.setFrom("{email}")
        javaMailSender.send(message)

        if (mailRepository.existsByEmail(email)) {
            val mail = mailFacade.getByMail(email)
            mail.updateCode(code)
            mail.updateIsChecked(false)
        } else {
            mailRepository.save(Mail(email, code, false))
        }
    }

    fun createRandomNumber(): Int {
        val random = SecureRandom()
        return random.nextInt(1000, 9999)
    }
}