package com.gbook.gbookbackend.domain.user.presentation

import com.gbook.gbookbackend.domain.user.presentation.dto.request.UpdateUserRequest
import com.gbook.gbookbackend.domain.user.presentation.dto.request.UserLoginRequest
import com.gbook.gbookbackend.domain.user.presentation.dto.request.UserSignUpRequest
import com.gbook.gbookbackend.domain.user.presentation.dto.response.TokenResponse
import com.gbook.gbookbackend.domain.user.service.MailService
import com.gbook.gbookbackend.domain.user.service.UpdateUserService
import com.gbook.gbookbackend.domain.user.service.UploadProfileService
import com.gbook.gbookbackend.domain.user.service.UserLoginService
import com.gbook.gbookbackend.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RequestPart
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val mailService: MailService,
    private val userLoginService: UserLoginService,
    private val updateUserService: UpdateUserService,
    private val uploadProfileService: UploadProfileService
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

    @ResponseStatus(OK)
    @PostMapping("/login")
    fun login(@RequestBody @Valid request: UserLoginRequest): TokenResponse {
        return userLoginService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping
    fun updateUserInfo(@RequestBody @Valid request: UpdateUserRequest) {
        updateUserService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/profile")
    fun uploadProfile(@RequestPart file: MultipartFile) {
        uploadProfileService.execute(file)
    }
}