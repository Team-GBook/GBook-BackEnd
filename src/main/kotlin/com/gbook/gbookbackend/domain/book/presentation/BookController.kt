package com.gbook.gbookbackend.domain.book.presentation

import com.gbook.gbookbackend.domain.book.service.LikeBookService
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")
@RestController
class BookController(
    private val likeBookService: LikeBookService,
) {
    @ResponseStatus(NO_CONTENT)
    @PutMapping("/like/{isbn}")
    fun likeBook(@PathVariable isbn: String) {
        likeBookService.execute(isbn)
    }
}