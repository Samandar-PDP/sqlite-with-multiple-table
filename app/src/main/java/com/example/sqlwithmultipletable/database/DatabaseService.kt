package com.example.sqlwithmultipletable.database

import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.model.Football
import com.example.sqlwithmultipletable.model.Programming

interface DatabaseService {
    fun saveCar(car: Cars)
    fun saveFootball(football: Football)
    fun saveProg(programming: Programming)

    fun getAllCars(): List<Cars>
    fun getAllFootballs(): List<Football>
    fun getAllProgs(): List<Programming>

    fun updateCar(car: Cars)
    fun updateFootball(football: Football)
    fun updateProg(programming: Programming)

    fun deleteCar(carId: Int?)
}