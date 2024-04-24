package com.gbook.gbookbackend.global.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode
import com.gbook.gbookbackend.global.error.exception.GbookException

object TokenInvalidException : GbookException(ErrorCode.TOKEN_INVALID)