package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReplyRepository
import com.gbook.gbookbackend.domain.review.exception.CommentNotFoundException
import com.gbook.gbookbackend.domain.review.exception.ForbiddenUserException
import com.gbook.gbookbackend.domain.review.exception.ReplyNotFoundException
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class DeleteReplyService(
    private val userFacade: UserFacade,
    private val replyRepository: ReplyRepository
) {
    @Transactional
    fun execute(id: UUID) {
        val user = userFacade.getCurrentUser()
        val reply = replyRepository.findReplyById(id) ?: throw ReplyNotFoundException

        if (reply.user != user) {
            throw ForbiddenUserException
        }

        replyRepository.delete(reply)
    }
}