package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewListResponse
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryReviewListService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository
) {
    @Transactional(readOnly = true)
    fun execute(isbn: String): QueryReviewListResponse {
        val user = userFacade.getCurrentUser()
        val reviewList: List<Review> = reviewRepository.findAllByIsbn(isbn)

        return QueryReviewListResponse(
            reviewList = reviewList.map {
                QueryReviewResponse(
                    isbn = it.isbn,
                    review = it.review,
                    reconstruction =  it.reconstruction,
                    analysis = it.analysis,
                    genre = it.genre,
                    isMine = it.user == user
                )
            }
        )
    }
}