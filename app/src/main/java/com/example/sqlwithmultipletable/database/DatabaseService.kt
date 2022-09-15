package com.example.sqlwithmultipletable.database

import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.model.Football
import com.example.sqlwithmultipletable.model.Programming

interface DatabaseService {
    fun saveCar(cars: Cars)
    fun saveFootball(football: Football)
    fun saveProg(programming: Programming)

    fun getAllCars(): List<Cars>
    fun getAllFootballs(): List<Football>
    fun getAllProgs(): List<Programming>
}