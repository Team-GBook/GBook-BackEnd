package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReplyRepository
import com.gbook.gbookbackend.domain.review.exception.CommentNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReplyListResponse
import com.gbook.gbookbackend.domain.review.presentation.dto.response.ReplyElement
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class QueryReplyListService(
    private val commentRepository: CommentRepository,
    private val replyRepository: ReplyRepository
) {
    @Transactional(readOnly = true)
    fun execute(id: UUID): QueryReplyListResponse {
        val comment = commentRepository.findCommentById(id) ?: throw CommentNotFoundException
        val replies = replyRepository.findAllByComment(comment)

        return QueryReplyListResponse(
            replies.map {
                ReplyElement(
                    it.id,
                    it.user.nickName,
                    it.content
                )
            }
        )
    }
}