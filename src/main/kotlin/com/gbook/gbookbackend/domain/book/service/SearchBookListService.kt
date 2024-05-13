package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.facade.BookFacade
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.utils.openfeign.client.BookFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchBookListService(
    private val bookFeign: BookFeign,
    private val userFacade: UserFacade,
    private val bookFacade: BookFacade
) {
    @Transactional
    fun execute(keyword: String, start: Int): GetBookListResponse {
        val user = userFacade.getCurrentUser()
        val response = bookFeign.searchBookList(
            query = keyword,
            start = start,
            version = 20131101
        )

        return GetBookListResponse(
            totalPage = response.totalResults / 10,
            items = response.item.map {
                bookFacade.getElement(it, user)
            }
        )
    }
}