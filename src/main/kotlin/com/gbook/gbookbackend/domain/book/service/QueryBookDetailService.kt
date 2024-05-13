package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.exception.BookNotFoundException
import com.gbook.gbookbackend.domain.book.facade.BookFacade
import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.utils.openfeign.client.BookFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryBookDetailService(
    private val bookFeign: BookFeign,
    private val userFacade: UserFacade,
    private val bookFacade: BookFacade
) {
    @Transactional
    fun execute(isbn: String): BookElement {
        val user = userFacade.getCurrentUser()
        val response = bookFeign.searchBookDetail(
            version = 20131101,
            itemIdType = "ISBN",
            itemId = isbn
        )

        if (response.item == null) {
            throw BookNotFoundException
        }

        return bookFacade.getElement(response.item.first(), user)
    }
}