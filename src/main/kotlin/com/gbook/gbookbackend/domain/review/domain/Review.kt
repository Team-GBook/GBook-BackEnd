package com.gbook.gbookbackend.domain.review.domain

import com.gbook.gbookbackend.domain.user.domain.Genre
import com.gbook.gbookbackend.domain.user.domain.User
import com.gbook.gbookbackend.global.entity.BaseUUIDEntity
import java.time.LocalDate
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_review")
class Review(
    @Column(columnDefinition = "CHAR(10)", nullable = false)
    val isbn: String,

    @Column(columnDefinition = "VARCHAR(50)", nullable = false)
    var title: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    var review: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    var reconstruction: String,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    var analysis: String,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var genre: Genre,

    @Column(columnDefinition = "DATE", nullable = false)
    val createdAt: LocalDate,

    user: User,
) : BaseUUIDEntity() {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set

    fun updateReview(title: String, review: String, reconstruction: String, analysis: String, genre: Genre) {
        this.title = title
        this.review = review
        this.reconstruction = reconstruction
        this.analysis = analysis
        this.genre = genre
    }
}