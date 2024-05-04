package com.gbook.gbookbackend.global.util.openfeign.client.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.FEIGN_BAD_REQUEST
import com.gbook.gbookbackend.global.error.exception.GbookException

object FeignBadRequestException : GbookException(FEIGN_BAD_REQUEST)