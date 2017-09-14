package com.github.demeureguillaume.entity

import javax.persistence.*

@Entity(name = "POST")
class Post : AuditableEntity() {
    @Column(name = "ID") @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0
    @Column(name = "TITLE")
    var title : String = ""
    @Column(name = "CONTENT")
    var content : String = ""
}
