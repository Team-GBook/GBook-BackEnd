package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.ReplyRepository
import com.gbook.gbookbackend.domain.review.exception.ForbiddenUserException
import com.gbook.gbookbackend.domain.review.exception.ReplyNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateReplyRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UpdateReplyService(
    private val userFacade: UserFacade,
    private val replyRepository: ReplyRepository
) {
    @Transactional
    fun execute(id: UUID, request: UpdateReplyRequest) {
        val user = userFacade.getCurrentUser()
        val reply = replyRepository.findReplyById(id) ?: throw ReplyNotFoundException

        if (reply.user != user) {
            throw ForbiddenUserException
        }

        reply.updateContent(request.content)
    }
}