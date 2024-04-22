package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.ALREADY_CHECKED_MAIL
import com.gbook.gbookbackend.global.error.exception.GbookException

object AlreadyCheckedMailException : GbookException(ALREADY_CHECKED_MAIL)