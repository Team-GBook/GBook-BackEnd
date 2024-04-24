package com.gbook.gbookbackend.global.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode
import com.gbook.gbookbackend.global.error.exception.GbookException

object TokenExpiredException : GbookException(ErrorCode.TOKEN_EXPIRED)