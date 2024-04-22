package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.INVALID_CODE
import com.gbook.gbookbackend.global.error.exception.GbookException

object InvalidCodeException : GbookException(INVALID_CODE)