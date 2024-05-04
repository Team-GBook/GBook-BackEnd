package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetAladinBookListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetBestSellerService(
    private val bookFeign: BookFeign
) {
    @Transactional
    fun execute(start: Int): GetAladinBookListResponse {
        return bookFeign.getBestSellerList(queryType = "Bestseller", start =  start, version = 20131101, searchTarget = "Book")
    }
}