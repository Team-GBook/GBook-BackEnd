package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode
import com.gbook.gbookbackend.global.error.exception.GbookException

object AlreadyUserException: GbookException(ErrorCode.ALREADY_USER)