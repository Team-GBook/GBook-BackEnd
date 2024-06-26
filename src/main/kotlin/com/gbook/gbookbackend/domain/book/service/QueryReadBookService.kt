package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.exception.BookNotFoundException
import com.gbook.gbookbackend.domain.book.facade.BookFacade
import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.review.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.utils.openfeign.client.BookFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryReadBookService(
    private val userFacade: UserFacade,
    private val reviewRepository: ReviewRepository,
    private val bookFeign: BookFeign,
    private val bookFacade: BookFacade
) {
    @Transactional
    fun execute(): GetBookListResponse {
        val user = userFacade.getCurrentUser()
        val reviews = reviewRepository.findAllByUser(user)
        val books = reviews.map {
            bookFeign.searchBookDetail(
                version = 20131101,
                itemIdType = "ISBN",
                itemId = it.isbn
            )
        }
        return GetBookListResponse(
            totalPage = 1,
            books.map {
                if (it.item == null) {
                    throw BookNotFoundException
                }
                bookFacade.getElement(it.item.first(), user)
            }
        )
    }
}