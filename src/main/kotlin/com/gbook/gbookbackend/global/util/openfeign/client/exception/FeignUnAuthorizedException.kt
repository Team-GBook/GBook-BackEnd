package com.gbook.gbookbackend.global.util.openfeign.client.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.FEIGN_UNAUTHORIZED
import com.gbook.gbookbackend.global.error.exception.GbookException

object FeignUnAuthorizedException : GbookException(FEIGN_UNAUTHORIZED)