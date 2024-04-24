package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode
import com.gbook.gbookbackend.global.error.exception.GbookException

object UserNotFoundException: GbookException(ErrorCode.NOT_FOUND_USER)