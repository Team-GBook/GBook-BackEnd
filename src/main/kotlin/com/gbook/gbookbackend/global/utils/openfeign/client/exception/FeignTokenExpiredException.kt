package com.gbook.gbookbackend.global.utils.openfeign.client.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.FEIGN_TOKEN_EXPIRED
import com.gbook.gbookbackend.global.error.exception.GbookException

object FeignTokenExpiredException : GbookException(FEIGN_TOKEN_EXPIRED)