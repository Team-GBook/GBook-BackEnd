package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.ReviewNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateReviewRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateReviewService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository
) {
    @Transactional
    fun execute(isbn: String, request: UpdateReviewRequest) {
        val user = userFacade.getCurrentUser()
        val review = reviewRepository.findByIsbnAndUser(isbn, user) ?: throw ReviewNotFoundException
        review.updateReview(request.title, request.review, request.reconstruction, request.analysis, request.genre)
    }
}