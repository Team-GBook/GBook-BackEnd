package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.global.util.openfeign.client.BookFeign
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetAladinBookListResponse
import com.google.gson.GsonBuilder
import com.google.gson.stream.JsonReader
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.io.StringReader

@Service
class SearchBookListService(
    private val bookFeign: BookFeign
) {
    @Transactional
    fun execute(keyword: String, start: Int): GetAladinBookListResponse {
        val response = bookFeign.searchBookList(query = keyword, start = start).trimIndent()
        val gson = GsonBuilder().create()
        val reader = JsonReader(StringReader(response)).apply { isLenient = true }

        return gson.fromJson(reader, GetAladinBookListResponse::class.java)
    }
}