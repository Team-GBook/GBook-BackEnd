package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.utils.aws.s3.S3Utils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class UploadProfileService(
    private val userFacade: UserFacade,
    private val s3Utils: S3Utils
) {
    @Transactional
    fun execute(file: MultipartFile) {
        val user = userFacade.getCurrentUser()
        user.updateProfile(s3Utils.upload(file))
    }
}