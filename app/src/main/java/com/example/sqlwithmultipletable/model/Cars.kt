package com.example.sqlwithmultipletable.model

import java.io.Serializable

class Cars: Serializable {
    var id: Int? = null
    var name: String? = null
    var brand: String? = null
    var color: String? = null
    var price: String? = null



    constructor(id: Int?, name: String?, brand: String?, color: String?, price: String?) {
        this.id = id
        this.name = name
        this.brand = brand
        this.color = color
        this.price = price
    }

    constructor(name: String?, brand: String?, color: String?, price: String?) {
        this.name = name
        this.brand = brand
        this.color = color
        this.price = price
    }
}