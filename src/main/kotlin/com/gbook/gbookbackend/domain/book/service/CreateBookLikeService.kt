package com.gbook.gbookbackend.domain.book.service

import com.gbook.gbookbackend.domain.book.domain.BookLike
import com.gbook.gbookbackend.domain.book.domain.repository.BookLikeRepository
import com.gbook.gbookbackend.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class CreateBookLikeService(
    private val bookLikeRepository: BookLikeRepository,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(isbn: String) {
        val user = userFacade.getCurrentUser()
        bookLikeRepository.save(BookLike(isbn, user))
    }
}