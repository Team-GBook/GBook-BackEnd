package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.Comment
import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.ReviewNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateCommentRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class CreateCommentService(
    private val userFacade: UserFacade,
    private val commentRepository: CommentRepository,
    private val reviewRepository: ReviewRepository
) {
    @Transactional
    fun execute(id: UUID, request: CreateCommentRequest) {
        val user = userFacade.getCurrentUser()
        val review: Review = reviewRepository.findReviewById(id) ?: throw ReviewNotFoundException
        commentRepository.save(Comment(request.content, review, user))
    }
}