package com.gbook.gbookbackend.domain.review.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.NOT_FOUND_COMMENT
import com.gbook.gbookbackend.global.error.exception.GbookException

object CommentNotFoundException : GbookException(NOT_FOUND_COMMENT)