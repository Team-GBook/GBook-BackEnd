package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetBookListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchBookListService(
    private val bookFeign: BookFeign
) {
    @Transactional
    fun execute(keyword: String): GetBookListResponse {
        return bookFeign.searchBookList(query = keyword)
    }
}