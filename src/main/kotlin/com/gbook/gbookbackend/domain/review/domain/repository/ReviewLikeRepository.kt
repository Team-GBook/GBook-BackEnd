package com.gbook.gbookbackend.domain.review.domain.repository

import com.gbook.gbookbackend.domain.review.domain.ReviewLike
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewLikeRepository : JpaRepository<ReviewLike, UUID> {
    fun countById(id: UUID): Int
}