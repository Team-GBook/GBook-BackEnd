package com.gbook.gbookbackend.domain.review.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.ALREADY_REVIEW
import com.gbook.gbookbackend.global.error.exception.GbookException

object AlreadyReviewException : GbookException(ALREADY_REVIEW)