package com.gbook.gbookbackend.domain.book.presentation

import com.gbook.gbookbackend.domain.book.presentation.dto.response.BookElement
import com.gbook.gbookbackend.domain.book.presentation.dto.response.GetBookListResponse
import com.gbook.gbookbackend.domain.book.service.GetBestSellerService
import com.gbook.gbookbackend.domain.book.service.LikeBookService
import com.gbook.gbookbackend.domain.book.service.QueryBookDetailService
import com.gbook.gbookbackend.domain.book.service.QueryBookListService
import com.gbook.gbookbackend.domain.book.service.QueryGenreBooksService
import com.gbook.gbookbackend.domain.book.service.QueryLikeBookListService
import com.gbook.gbookbackend.domain.book.service.QueryRecommendBookService
import com.gbook.gbookbackend.domain.book.service.QueryReadBookService
import com.gbook.gbookbackend.domain.user.domain.Genre
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
    private val queryBookListService: QueryBookListService,
    private val queryBookDetailService: QueryBookDetailService,
    private val queryRecommendBookService: QueryRecommendBookService,
    private val queryReadBookService: QueryReadBookService,
    private val queryLikeBookListService: QueryLikeBookListService,
    private val queryGenreBooksService: QueryGenreBooksService
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
        return queryBookListService.execute(keyword = keyword, start = start)
    }

    @ResponseStatus(OK)
    @GetMapping("/details/{isbn}")
    fun searchBookDetail(@PathVariable isbn: String): BookElement {
        return queryBookDetailService.execute(isbn = isbn)
    }
    
    @ResponseStatus(OK)
    @GetMapping
    fun queryRecommendBookList(): GetBookListResponse {
        return queryRecommendBookService.execute()
    }
    
    @ResponseStatus(OK)
    @GetMapping("/read")
    fun queryReadBookList(): GetBookListResponse {
        return queryReadBookService.execute()
    }
    @ResponseStatus(OK)
    @GetMapping("/like")
    fun queryLikeBookList(): GetBookListResponse {
        return queryLikeBookListService.execute()
    }

    @ResponseStatus(OK)
    @GetMapping("/genre")
    fun queryGenreBookList(@RequestParam("genre") genre: Genre): GetBookListResponse {
        return queryGenreBooksService.execute(genre)
    }
}