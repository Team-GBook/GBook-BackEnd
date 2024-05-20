package com.gbook.gbookbackend.domain.review.presentation

import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReviewRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateReviewRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewListResponse
import com.gbook.gbookbackend.domain.review.service.CreateReviewService
import com.gbook.gbookbackend.domain.review.service.DeleteReviewService
import com.gbook.gbookbackend.domain.review.service.QueryReviewListService
import com.gbook.gbookbackend.domain.review.service.UpdateReviewService
import org.springframework.http.HttpStatus.CREATED
import org.springframework.http.HttpStatus.NO_CONTENT
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
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
    private val updateReviewService: UpdateReviewService,
    private val deleteReviewService: DeleteReviewService,
    private val queryReviewListService: QueryReviewListService
) {
    @ResponseStatus(CREATED)
    @PostMapping("/{isbn}")
    fun createReview(@PathVariable isbn: String, @RequestBody @Valid request: CreateReviewRequest) {
        createReviewService.execute(isbn, request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/{isbn}")
    fun updateReview(@PathVariable isbn: String, @RequestBody @Valid request: UpdateReviewRequest) {
        updateReviewService.execute(isbn, request)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{isbn}")
    fun deleteReview(@PathVariable isbn: String) {
        deleteReviewService.execute(isbn)
    }

    @GetMapping("/{isbn}")
    fun searchReviewList(@PathVariable isbn: String): QueryReviewListResponse {
        return queryReviewListService.execute(isbn)
    }
}