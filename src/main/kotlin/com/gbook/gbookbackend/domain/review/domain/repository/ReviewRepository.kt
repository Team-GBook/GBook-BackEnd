package com.gbook.gbookbackend.domain.review.domain.repository

import com.gbook.gbookbackend.domain.review.domain.Review
import com.gbook.gbookbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional
import java.util.UUID

interface ReviewRepository : JpaRepository<Review, UUID> {
    fun countByIsbn(isbn: String): Int
    fun existsByIsbnAndUser(isbn: String, user: User): Boolean
    fun findByIsbnAndUser(isbn: String, user: User): Review?
    fun findAllByIsbn(isbn: String): List<Review>
}