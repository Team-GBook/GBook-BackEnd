package com.gbook.gbookbackend.domain.book.presentation

import com.gbook.gbookbackend.domain.book.service.GetBestSellerService
import com.gbook.gbookbackend.domain.book.service.LikeBookService
import com.gbook.gbookbackend.domain.book.service.SearchBookListService
import com.gbook.gbookbackend.global.util.openfeign.client.dto.GetBookListResponse
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")
@RestController
class BookController(
    private val likeBookService: LikeBookService,
    private val getBestSellerService: GetBestSellerService,
    private val searchBookListService: SearchBookListService
) {
    @ResponseStatus(NO_CONTENT)
    @PutMapping("/like/{isbn}")
    fun likeBook(@PathVariable isbn: String) {
        likeBookService.execute(isbn)
    }

    @ResponseStatus(OK)
    @GetMapping("/bestSeller")
    fun getBestSeller(): GetBookListResponse {
        return getBestSellerService.execute()
    }

    @ResponseStatus(OK)
    @PutMapping("/like/{keyword}")
    fun searchBookList(@PathVariable keyword: String): GetBookListResponse {
        return searchBookListService.execute(keyword = keyword)
    }
}