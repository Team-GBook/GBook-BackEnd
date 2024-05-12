package com.gbook.gbookbackend.domain.review.presentation

import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReviewRequest
import com.gbook.gbookbackend.domain.review.service.CreateReviewService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@RequestMapping("/reviews")
@RestController
class ReviewController(
    private val createReviewService: CreateReviewService,
) {
    @ResponseStatus(CREATED)
    @PostMapping("/{isbn}")
    fun createReview(@PathVariable isbn: String, @RequestBody @Valid request: CreateReviewRequest) {
        createReviewService.execute(isbn, request)
    }
}