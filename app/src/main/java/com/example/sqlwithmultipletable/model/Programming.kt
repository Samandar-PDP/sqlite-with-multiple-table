package com.example.sqlwithmultipletable.model

import java.io.Serializable

class Programming: Serializable {
    var id: Int? = null
    var name: String? = null
    var date: String? = null
    var whatUsed: String? = null


    constructor(id: Int?, name: String?, date: String?, whatUsed: String?) {
        this.id = id
        this.name = name
        this.date = date
        this.whatUsed = whatUsed
    }

    constructor(name: String?, date: String?, whatUsed: String?) {
        this.name = name
        this.date = date
        this.whatUsed = whatUsed
    }
}