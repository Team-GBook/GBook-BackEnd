package com.gbook.gbookbackend.domain.book.domain.repository

import com.gbook.gbookbackend.domain.book.domain.Review
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReviewRepository : JpaRepository<Review, UUID> {
    fun countByIsbn(isbn: String): Int
}