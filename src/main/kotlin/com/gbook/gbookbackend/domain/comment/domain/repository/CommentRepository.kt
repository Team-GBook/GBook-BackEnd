package com.gbook.gbookbackend.domain.comment.domain.repository

import com.gbook.gbookbackend.domain.comment.domain.Comment
import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.review.domain.ReviewLike
import com.gbook.gbookbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface CommentRepository : JpaRepository<Comment, UUID> {
    fun countByReview(review: Review): Int
}