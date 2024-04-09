package com.gbook.gbookbackend.global.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.INTERNAL_SERVER_ERROR
import com.gbook.gbookbackend.global.error.exception.GbookException

object InternalServerError : GbookException(INTERNAL_SERVER_ERROR)