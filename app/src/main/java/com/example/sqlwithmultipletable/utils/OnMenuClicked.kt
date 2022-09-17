package com.example.sqlwithmultipletable.utils

import com.example.sqlwithmultipletable.model.Cars

interface OnMenuClicked {
    fun onMenuClicked(cars: Cars, pos: Int)
}