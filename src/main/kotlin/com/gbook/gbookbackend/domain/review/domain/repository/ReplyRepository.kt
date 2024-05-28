package com.gbook.gbookbackend.domain.review.domain.repository

import com.gbook.gbookbackend.domain.review.domain.Comment
import com.gbook.gbookbackend.domain.review.domain.Reply
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReplyRepository : JpaRepository<Reply, UUID> {
    fun findReplyById(id: UUID): Reply?
    fun findAllByComment(comment: Comment): List<Reply>
    fun countAllByComment(comment: Comment): Int
}