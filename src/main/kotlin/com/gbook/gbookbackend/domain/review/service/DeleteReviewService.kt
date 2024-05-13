package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service

@Service
class DeleteReviewService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository
) {
    fun execute(isbn: String) {
        val user = userFacade.getCurrentUser()
        reviewRepository.deleteByIsbnAndUser(isbn, user)
    }
}