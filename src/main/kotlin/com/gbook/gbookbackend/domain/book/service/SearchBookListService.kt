package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.domain.repository.BookLikeRepository
import com.gbook.gbookbackend.domain.book.domain.repository.ReviewRepository
import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetAladinBookListResponse
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.StringReader

@Service
class SearchBookListService(
    private val bookFeign: BookFeign,
    private val userFacade: UserFacade,
    private val bookLikeRepository: BookLikeRepository,
    private val reviewRepository: ReviewRepository
) {
    @Transactional
    fun execute(keyword: String, start: Int): GetBookListResponse {
        val user = userFacade.getCurrentUser()
        val response = bookFeign.searchBookList(query = keyword, start = start).trimIndent()
        val gson = GsonBuilder().create()
        val reader = JsonReader(StringReader(response)).apply { isLenient = true }

        val data: GetAladinBookListResponse = gson.fromJson(reader, GetAladinBookListResponse::class.java)

        return GetBookListResponse(
            totalPage = data.totalResults / 10,
            items = data.item.map {
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