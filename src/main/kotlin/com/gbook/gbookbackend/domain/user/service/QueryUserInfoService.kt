package com.gbook.gbookbackend.domain.user.service

import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.domain.user.presentation.dto.response.QueryUserInfoResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryUserInfoService(
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): QueryUserInfoResponse {
        val user = userFacade.getCurrentUser()
        return QueryUserInfoResponse(user.email, user.nickName, user.genre, user.profile)
    }
}