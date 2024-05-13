package com.gbook.gbookbackend.domain.book.presentation

import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.book.service.GetBestSellerService
import com.gbook.gbookbackend.domain.book.service.LikeBookService
import com.gbook.gbookbackend.domain.book.service.SearchBookDetailService
import com.gbook.gbookbackend.domain.book.service.SearchBookListService
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.http.HttpStatus.OK
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")
@RestController
class BookController(
    private val likeBookService: LikeBookService,
    private val getBestSellerService: GetBestSellerService,
    private val searchBookListService: SearchBookListService,
    private val searchBookDetailService: SearchBookDetailService
) {
    @ResponseStatus(NO_CONTENT)
    @PutMapping("/like/{isbn}")
    fun likeBook(@PathVariable isbn: String) {
        likeBookService.execute(isbn)
    }

    @ResponseStatus(OK)
    @GetMapping("/bestSeller")
    fun getBestSeller(@RequestParam("start") start: Int): GetBookListResponse {
        return getBestSellerService.execute(start = start)
    }

    @ResponseStatus(OK)
    @GetMapping("/search/{keyword}")
    fun searchBookList(@PathVariable keyword: String, @RequestParam("start") start: Int): GetBookListResponse {
        return searchBookListService.execute(keyword = keyword, start = start)
    }

    @ResponseStatus(OK)
    @GetMapping("/details/{isbn}")
    fun searchBookDetail(@PathVariable isbn: String): BookElement {
        return searchBookDetailService.execute(isbn = isbn)
    }
}