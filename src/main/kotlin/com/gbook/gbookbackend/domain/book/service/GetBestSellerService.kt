package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.domain.repository.BookLikeRepository
import com.gbook.gbookbackend.domain.book.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetBestSellerService(
    private val bookFeign: BookFeign,
    private val userFacade: UserFacade,
    private val bookLikeRepository: BookLikeRepository,
    private val reviewRepository: ReviewRepository
) {
    @Transactional
    fun execute(start: Int): GetBookListResponse {
        val user = userFacade.getCurrentUser()
        val response = bookFeign.getBestSellerList(
            queryType = "Bestseller",
            start = start,
            version = 20131101,
            searchTarget = "Book"
        )

        return GetBookListResponse(
            totalPage = response.totalResults / 10,
            items = response.item.map {
                val likeCount = bookLikeRepository.countByIsbn(it.isbn)
                val reviewCount = reviewRepository.countByIsbn(it.isbn)
                BookElement(
                    it.title,
                    it.author,
                    it.isbn,
                    it.cover,
                    it.publisher,
                    reviewCount,
                    likeCount,
                    bookLikeRepository.existsByIsbnAndUser(it.isbn, user)
                )
            }
        )
    }
}