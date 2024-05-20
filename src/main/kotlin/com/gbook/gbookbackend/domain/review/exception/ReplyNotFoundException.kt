package com.gbook.gbookbackend.domain.review.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.NOT_FOUND_REPLY
import com.gbook.gbookbackend.global.error.exception.GbookException

object ReplyNotFoundException : GbookException(NOT_FOUND_REPLY)