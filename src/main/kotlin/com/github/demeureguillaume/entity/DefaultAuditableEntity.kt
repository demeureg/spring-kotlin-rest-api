package com.github.demeureguillaume.entity

import org.hibernate.envers.NotAudited
import org.springframework.data.annotation.CreatedBy
import org.springframework.data.annotation.CreatedDate
import org.springframework.data.annotation.LastModifiedBy
import org.springframework.data.annotation.LastModifiedDate
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import java.io.Serializable
import java.time.LocalDateTime
import javax.persistence.*

/**
 * Super class for the Spring Data JPA Auditing information
 *
 * All the field in this class will be stored in *Revision entity except "CREATION_DATE" and "CREATED_BY" filed
 */
@MappedSuperclass
@EntityListeners(AuditingEntityListener::class)
open class DefaultAuditableEntity : Serializable {
    @Column(name="ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long? = null
    @Column(name="CREATION_DATE", nullable=false, updatable = false) @CreatedDate @NotAudited
    var createdDate : LocalDateTime? = null
    @Column(name="UPDATE_DATE", nullable=false, updatable = false) @LastModifiedDate
    var lastModifiedDate: LocalDateTime? = null
    @Column(name="CREATED_BY", nullable=false, updatable = false)  @CreatedBy @NotAudited
    var createdBy : String? = null
    @Column(name="UPDATED_BY", nullable=false, updatable = false) @LastModifiedBy
    var lastModifiedBy: String? = null
    @Column(name="VERSION") @Version
    var version: Long? = null
}