package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.Comment
import com.gbook.gbookbackend.domain.review.domain.Reply
import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReplyRepository
import com.gbook.gbookbackend.domain.review.exception.CommentNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReplyRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CreateReplyService(
    private val userFacade: UserFacade,
    private val replyRepository: ReplyRepository,
    private val commentRepository: CommentRepository
) {
    @Transactional
    fun execute(id: UUID, request: CreateReplyRequest) {
        val user = userFacade.getCurrentUser()
        val comment: Comment = commentRepository.findCommentById(id) ?: throw CommentNotFoundException
        replyRepository.save(Reply(request.content, comment, user))
    }
}