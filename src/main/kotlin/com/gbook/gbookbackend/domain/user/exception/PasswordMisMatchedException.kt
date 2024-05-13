package com.gbook.gbookbackend.domain.user.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode
import com.gbook.gbookbackend.global.error.exception.GbookException

object PasswordMisMatchedException: GbookException(ErrorCode.PASSWORD_MIS_MATCHED)