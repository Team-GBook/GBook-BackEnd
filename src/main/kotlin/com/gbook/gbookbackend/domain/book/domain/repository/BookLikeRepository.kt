package com.gbook.gbookbackend.domain.book.domain.repository

import com.gbook.gbookbackend.domain.book.domain.BookLike
import com.gbook.gbookbackend.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookLikeRepository : JpaRepository<BookLike, UUID> {
    fun deleteByIsbnAndUser(isbn: String, user: User)
    fun existsByIsbnAndUser(isbn: String, user: User): Boolean
}