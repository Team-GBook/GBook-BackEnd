package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.ReviewNotFoundException
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class DeleteReviewService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository
) {
    fun execute(isbn: String) {
        val user = userFacade.getCurrentUser()
        val review: Review? = reviewRepository.findByIsbnAndUser(isbn, user)
        if (review == null) {
            throw ReviewNotFoundException
        } else {
            reviewRepository.delete(review)
        }
    }
}