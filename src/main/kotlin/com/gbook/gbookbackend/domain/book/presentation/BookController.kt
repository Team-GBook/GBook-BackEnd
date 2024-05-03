package com.gbook.gbookbackend.domain.book.presentation

import com.gbook.gbookbackend.domain.book.service.CreateBookLikeService
import com.gbook.gbookbackend.domain.book.service.DeleteBookLikeService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController

@RequestMapping("/books")
@RestController
class BookController(
    private val createBookLikeService: CreateBookLikeService,
    private val deleteBookLikeService: DeleteBookLikeService,
) {
    @ResponseStatus(CREATED)
    @PostMapping("/like/{isbn}")
    fun likeBook(@PathVariable isbn: String) {
        createBookLikeService.execute(isbn)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/dislike/{isbn}")
    fun dislikeBook(@PathVariable isbn: String) {
        deleteBookLikeService.execute(isbn)
    }
}