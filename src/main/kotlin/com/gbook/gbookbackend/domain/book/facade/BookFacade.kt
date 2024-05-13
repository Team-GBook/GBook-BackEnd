package com.gbook.gbookbackend.domain.book.facade

import com.gbook.gbookbackend.domain.book.domain.repository.BookLikeRepository
import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.global.utils.openfeign.client.dto.AladinBookElement
import org.springframework.stereotype.Component

@Component
class BookFacade(
    private val bookLikeRepository: BookLikeRepository,
    private val reviewRepository: ReviewRepository,
) {
    fun getElement(res: AladinBookElement, user: User): BookElement {
        val likeCount = bookLikeRepository.countByIsbn(res.isbn)
        val reviewCount = reviewRepository.countByIsbn(res.isbn)
        return BookElement(
            res.title,
            res.author,
            res.isbn,
            res.cover,
            res.publisher,
            res.description,
            reviewCount,
            likeCount,
            bookLikeRepository.existsByIsbnAndUser(res.isbn, user)
        )
    }
}