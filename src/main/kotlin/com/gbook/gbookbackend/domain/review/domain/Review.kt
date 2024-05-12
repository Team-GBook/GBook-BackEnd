package com.gbook.gbookbackend.domain.review.domain

import com.gbook.gbookbackend.domain.user.domain.Genre
import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_review")
class Review(
    @Column(columnDefinition = "CHAR(10)", unique = true, nullable = false)
    val isbn: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val review: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val reconstruction: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    val analysis: String,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var genre: Genre,

    user: User,
) : BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set
}