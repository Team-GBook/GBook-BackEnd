package com.gbook.gbookbackend.domain.user.domain

import com.gbook.gbookbackend.global.entity.BaseUUIDEntity
import javax.persistence.Column
import javax.persistence.Entity

@Entity(name = "tbl_check_mail")
class Mail (
    @Column(columnDefinition = "VARCHAR(60)", nullable = false)
    val email: String,

    @Column(columnDefinition = "INT(4)", nullable = false)
    var code: Int,

    @Column(columnDefinition = "BIT(1)", nullable = false)
    var isChecked: Boolean,
): BaseUUIDEntity() {
    fun updateCode(code: Int) {
        this.code = code
    }

    fun updateIsChecked(isChecked: Boolean) {
        this.isChecked = isChecked
    }
}