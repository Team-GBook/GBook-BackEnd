package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.INVALID_MAIL
import com.gbook.gbookbackend.global.error.exception.GbookException

object InvalidMailException : GbookException(INVALID_MAIL)