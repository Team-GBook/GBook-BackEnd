package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.NOT_FOUND_MAIL
import com.gbook.gbookbackend.global.error.exception.GbookException

object MailNotFoundException : GbookException(NOT_FOUND_MAIL)