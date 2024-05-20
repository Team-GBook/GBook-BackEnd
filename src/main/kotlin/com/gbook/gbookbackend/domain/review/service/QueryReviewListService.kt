package com.gbook.gbookbackend.domain.review.service

import com.gbook.gbookbackend.domain.comment.domain.repository.CommentRepository
import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewLikeRepository
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewListResponse
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryReviewListService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository,
    private val reviewLikeRepository: ReviewLikeRepository,
    private val commentRepository: CommentRepository,
) {
    @Transactional(readOnly = true)
    fun execute(isbn: String): QueryReviewListResponse {
        val user = userFacade.getCurrentUser()
        val reviewList: List<Review> = reviewRepository.findAllByIsbn(isbn)

        return QueryReviewListResponse(
            reviewList = reviewList.map {
                val likeCount = reviewLikeRepository.countById(it.id)
                val commentCount = commentRepository.countByReview(it)
                QueryReviewResponse(
                    isbn = it.isbn,
                    title = it.title,
                    user = it.user.nickName,
                    isMine = it.user == user,
                    createdAt = it.createdAt,
                    likeCount = likeCount,
                    commentCount = commentCount
                )
            }
        )
    }
}