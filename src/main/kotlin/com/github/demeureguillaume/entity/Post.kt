package com.github.demeureguillaume.entity

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

@Entity
class Post {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id : Long = 0
    var title : String = ""
    var content : String = ""
}