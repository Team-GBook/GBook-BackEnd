package com.gbook.gbookbackend.domain.review.presentation

import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateCommentRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReplyRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.CreateReviewRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateCommentRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateReplyRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.request.UpdateReviewRequest
import com.gbook.gbookbackend.domain.review.presentation.dto.response.QueryReviewListResponse
import com.gbook.gbookbackend.domain.review.service.CreateCommentService
import com.gbook.gbookbackend.domain.review.service.CreateReplyService
import com.gbook.gbookbackend.domain.review.service.CreateReviewService
import com.gbook.gbookbackend.domain.review.service.DeleteCommentService
import com.gbook.gbookbackend.domain.review.service.DeleteReplyService
import com.gbook.gbookbackend.domain.review.service.DeleteReviewService
import com.gbook.gbookbackend.domain.review.service.QueryReviewListService
import com.gbook.gbookbackend.domain.review.service.UpdateCommentService
import com.gbook.gbookbackend.domain.review.service.UpdateReplyService
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
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/reviews")
@RestController
class ReviewController(
    private val createReviewService: CreateReviewService,
    private val updateReviewService: UpdateReviewService,
    private val deleteReviewService: DeleteReviewService,
    private val queryReviewListService: QueryReviewListService,
    private val createCommentService: CreateCommentService,
    private val createReplyService: CreateReplyService,
    private val updateCommentService: UpdateCommentService,
    private val updateReplyService: UpdateReplyService,
    private val deleteCommentService: DeleteCommentService,
    private val deleteReplyService: DeleteReplyService
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

    @ResponseStatus(CREATED)
    @PostMapping("/comment/{review-id}")
    fun createComment(@PathVariable("review-id") id: UUID, @RequestBody @Valid request: CreateCommentRequest) {
        createCommentService.execute(id, request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/comment/{comment-id}")
    fun updateComment(@PathVariable("comment-id") id: UUID, @RequestBody @Valid request: UpdateCommentRequest) {
        updateCommentService.execute(id, request)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/comment/{comment-id}")
    fun deleteComment(@PathVariable("comment-id") id: UUID) {
        deleteCommentService.execute(id)
    }

    @ResponseStatus(CREATED)
    @PostMapping("/reply/{comment-id}")
    fun createCReply(@PathVariable("comment-id") id: UUID, @RequestBody @Valid request: CreateReplyRequest) {
        createReplyService.execute(id, request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/reply/{reply-id}")
    fun updateReply(@PathVariable("reply-id") id: UUID, @RequestBody @Valid request: UpdateReplyRequest) {
        updateReplyService.execute(id, request)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/reply/{reply-id}")
    fun deleteReply(@PathVariable("reply-id") id: UUID) {
        deleteReplyService.execute(id)
    }
}