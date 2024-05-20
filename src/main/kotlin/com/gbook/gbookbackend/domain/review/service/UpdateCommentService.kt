package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.exception.CommentNotFoundException
import com.gbook.gbookbackend.domain.review.exception.ForbiddenUserException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateCommentRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class UpdateCommentService(
    private val userFacade: UserFacade,
    private val commentRepository: CommentRepository
) {
    @Transactional
    fun execute(id: UUID, request: UpdateCommentRequest) {
        val user = userFacade.getCurrentUser()
        val comment = commentRepository.findCommentById(id) ?: throw CommentNotFoundException

        if (comment.user == user) {
            throw ForbiddenUserException
        }

        comment.updateContent(request.content)
    }
}