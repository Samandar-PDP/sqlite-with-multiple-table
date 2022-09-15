package com.example.sqlwithmultipletable.model

import java.io.Serializable

class Football : Serializable {
    var id: Int? = null
    var name: String? = null
    var liga: String? = null
    var date: String? = null
    var place: String? = null

    constructor(id: Int?, name: String?, liga: String?, date: String?, place: String?) {
        this.id = id
        this.name = name
        this.liga = liga
        this.date = date
        this.place = place
    }

    constructor(name: String?, liga: String?, date: String?, place: String?) {
        this.name = name
        this.liga = liga
        this.date = date
        this.place = place
    }
}