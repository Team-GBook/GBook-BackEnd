package com.gbook.gbookbackend.domain.review.domain

import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_reply")
class Reply(
    @Column(columnDefinition = "VARCHAR(1000)", nullable = false)
    var content: String,

    comment: Comment,
    user: User,
) : BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "comment_id", columnDefinition = "BINARY(16)", nullable = false)
    var comment = comment
        protected set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set

    fun updateContent(content: String) {
        this.content = content
    }
}