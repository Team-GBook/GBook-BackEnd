package com.gbook.gbookbackend.domain.book.domain.repository

import com.gbook.gbookbackend.domain.book.domain.BookLike
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.global.utils.openfeign.client.dto.GetAladinBookListResponse
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface BookLikeRepository : JpaRepository<BookLike, UUID> {
    fun deleteByIsbnAndUser(isbn: String, user: User)
    fun existsByIsbnAndUser(isbn: String, user: User): Boolean
    fun countByIsbn(isbn: String): Int
}