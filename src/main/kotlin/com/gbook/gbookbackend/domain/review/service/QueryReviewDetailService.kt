package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.exception.ReviewNotFoundException
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewDetailResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class QueryReviewDetailService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository,
) {
    @Transactional(readOnly = true)
    fun execute(id: UUID): QueryReviewDetailResponse {
        val user = userFacade.getCurrentUser()
        val review = reviewRepository.findReviewById(id) ?: throw ReviewNotFoundException
        return QueryReviewDetailResponse(
            review.id,
            review.isbn,
            review.title,
            review.user.nickName,
            review.review,
            review.reconstruction,
            review.analysis,
            review.user == user,
            review.createdAt
        )
    }
}