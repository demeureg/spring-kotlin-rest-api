package com.github.demeureguillaume.entity

import org.hibernate.envers.AuditTable
import org.hibernate.envers.Audited
import org.springframework.data.jpa.domain.support.AuditingEntityListener
import javax.persistence.*

@Audited
@AuditTable("POST_AUDIT")
@Entity(name="POST")
class Post : DefaultAuditableEntity() {
    @Column(name="TITLE", nullable=false)
    var title : String? = null
    @Column(name="CONTENT", nullable=false)
    var content : String? = null
}
