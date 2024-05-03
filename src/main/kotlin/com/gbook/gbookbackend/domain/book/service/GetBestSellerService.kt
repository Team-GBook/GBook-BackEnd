package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.domain.BookLike
import com.gbook.gbookbackend.domain.book.domain.repository.BookLikeRepository
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetBookListResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class GetBestSellerService(
    private val bookFeign: BookFeign
) {
    @Transactional
    fun execute(): GetBookListResponse {
        return bookFeign.getBestSellerList(queryType = "Bestseller")
    }
}