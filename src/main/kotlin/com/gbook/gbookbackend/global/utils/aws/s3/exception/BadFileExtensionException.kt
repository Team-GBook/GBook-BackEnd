package com.gbook.gbookbackend.global.utils.aws.s3.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.BAD_FILE_EXTENSION
import com.gbook.gbookbackend.global.error.exception.GbookException

object BadFileExtensionException : GbookException(BAD_FILE_EXTENSION)