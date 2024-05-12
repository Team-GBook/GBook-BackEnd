package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.AlreadyReviewException
import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReviewRequest
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateReviewService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository,
) {
    @Transactional
    fun execute(isbn: String, request: CreateReviewRequest) {
        val user = userFacade.getCurrentUser()

        if (reviewRepository.existsByIsbnAndUser(isbn, user)) {
            throw AlreadyReviewException
        }

        reviewRepository.save(
            Review(
                isbn,
                request.review,
                request.reconstruction,
                request.analysis,
                request.genre,
                user
            )
        )
    }
}