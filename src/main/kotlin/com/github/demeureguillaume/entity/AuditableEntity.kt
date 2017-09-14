package com.github.demeureguillaume.entity

import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.Column
import javax.persistence.EntityListeners
import javax.persistence.MappedSuperclass

@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class AuditableEntity : Serializable {
    @Column(name="CREATED_DATE", nullable=false, updatable = false) @CreatedDate
    var createdDate : LocalDateTime = LocalDateTime.now()
    @Column(name="LAST_MODIFIED_DATE", nullable=false, updatable = false) @LastModifiedDate
    var lastModifiedDate: LocalDateTime = LocalDateTime.now()
    @Column(name="CREATED_BY", nullable=false, updatable = false)  @CreatedBy
    var createdBy : String = ""
    @Column(name="UPDATED_BY", nullable=false, updatable = false) @LastModifiedBy
    var lastModifiedBy: String = ""
}