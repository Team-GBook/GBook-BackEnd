package com.gbook.gbookbackend.global.utils.openfeign.client.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.FEIGN_FORBIDDEN
import com.gbook.gbookbackend.global.error.exception.GbookException

object FeignForbiddenException : GbookException(FEIGN_FORBIDDEN)