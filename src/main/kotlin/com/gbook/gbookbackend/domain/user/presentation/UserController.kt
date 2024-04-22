package com.gbook.gbookbackend.domain.user.presentation

import com.gbook.gbookbackend.domain.user.presentation.dto.UserSignUpRequest
import com.gbook.gbookbackend.domain.user.service.MailService
import com.gbook.gbookbackend.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val mailService: MailService,
) {
    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    fun signup(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @PostMapping("/email")
    fun sendEmail(@RequestParam email: String) {
        mailService.send(email)
    }

    @ResponseStatus(NO_CONTENT)
    @PostMapping("/email/check")
    fun checkEmailCode(@RequestParam email: String, @RequestParam code: Int) {
        mailService.check(email, code)
    }
}