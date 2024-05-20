package com.gbook.gbookbackend.domain.review.domain.repository

import com.gbook.gbookbackend.domain.review.domain.ReviewLike
import com.gbook.gbookbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewLikeRepository : JpaRepository<ReviewLike, UUID> {
    fun deleteByIdAndUser(id: UUID, user: User)
    fun existsByIdAndUser(id: UUID, user: User): Boolean
    fun countById(id: UUID): Int
}