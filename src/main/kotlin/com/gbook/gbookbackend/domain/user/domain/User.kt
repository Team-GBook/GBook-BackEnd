package com.gbook.gbookbackend.domain.user.domain

import com.gbook.gbookbackend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_user")
class User(
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val email: String,

    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val password: String,

    @Column(columnDefinition = "VARCHAR(15)", nullable = false)
    var nickName: String,

    @Column(columnDefinition = "VARCHAR(10)", nullable = false)
    var genre: Genre,

    @Column(columnDefinition = "VARCHAR(2000)", nullable = false)
    var profile: String
): BaseUUIDEntity() {
    fun updateUserInfo(nickName: String, genre: Genre) {
        this.nickName = nickName
        this.genre = genre
    }

    fun updateProfile(profile: String) {
        this.profile = profile
    }
}