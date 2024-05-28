package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReplyRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.ReviewNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.response.CommentElement
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryCommentListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class QueryCommentListService(
    private val reviewRepository: ReviewRepository,
    private val commentRepository: CommentRepository,
    private val replyRepository: ReplyRepository
) {
    @Transactional(readOnly = true)
    fun execute(id: UUID): QueryCommentListResponse {
        val review = reviewRepository.findReviewById(id) ?: throw ReviewNotFoundException
        val comments = commentRepository.findAllByReview(review)

        return QueryCommentListResponse(
            comments.map {
                CommentElement(
                    it.id,
                    it.user.nickName,
                    it.content,
                    replyRepository.countAllByComment(it)
                )
            }
        )
    }
}