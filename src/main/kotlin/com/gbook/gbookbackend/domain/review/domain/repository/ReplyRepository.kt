package com.gbook.gbookbackend.domain.review.domain.repository

import com.gbook.gbookbackend.domain.review.domain.Reply
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface ReplyRepository : JpaRepository<Reply, UUID>