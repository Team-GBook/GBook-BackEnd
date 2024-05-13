package com.gbook.gbookbackend.domain.book.exception

import com.gbook.gbookbackend.global.error.exception.ErrorCode.NOT_FOUND_BOOK
import com.gbook.gbookbackend.global.error.exception.GbookException

object BookNotFoundException : GbookException(NOT_FOUND_BOOK)