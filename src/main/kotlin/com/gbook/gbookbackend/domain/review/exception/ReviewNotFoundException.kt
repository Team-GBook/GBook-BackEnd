package com.gbook.gbookbackend.domain.review.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.NOT_FOUND_REVIEW
import com.gbook.gbookbackend.global.error.exception.GbookException

object ReviewNotFoundException : GbookException(NOT_FOUND_REVIEW)