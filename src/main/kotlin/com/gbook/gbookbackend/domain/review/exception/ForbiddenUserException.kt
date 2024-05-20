package com.gbook.gbookbackend.domain.review.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.FORBIDDEN_USER
import com.gbook.gbookbackend.global.error.exception.GbookException

object ForbiddenUserException : GbookException(FORBIDDEN_USER)