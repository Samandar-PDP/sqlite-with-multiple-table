package com.example.sqlwithmultipletable.database

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.model.Football
import com.example.sqlwithmultipletable.model.Programming
import com.example.sqlwithmultipletable.utils.Constants

class MyDatabase(context: Context) :
    SQLiteOpenHelper(context, Constants.DB_NAME, null, Constants.DB_VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val carQuery =
            "CREATE TABLE ${Constants.CAR_TABLE}(${Constants.CAR_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.CAR_NAME} TEXT NOT NULL, ${Constants.CAR_BRAND} TEXT NOT NULL, ${Constants.CAR_COLOR} TEXT NOT NULL  , ${Constants.CAR_PRICE} TEXT NOT NULL)"
        val progQuery =
            "CREATE TABLE ${Constants.PROG_TABLE}(${Constants.PROG_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.PROG_NAME} TEXT NOT NULL, ${Constants.PROG_DATE} TEXT NOT NULL, ${Constants.PROG_WHAT} TEXT NOT NULL)"
        val footQuery =
            "CREATE TABLE ${Constants.FOOTBALL_TABLE}(${Constants.FOOT_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.FOOT_NAME} TEXT NOT NULL, ${Constants.FOOT_DATE} TEXT NOT NULL, ${Constants.FOOT_LIGA} TEXT NOT NULL, ${Constants.FOOT_PLACE} TEXT NOT NULL)"

        db?.execSQL(footQuery)
        db?.execSQL(progQuery)
        db?.execSQL(carQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) = Unit


    override fun saveCar(car: Cars) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.CAR_NAME, car.name)
        contentValues.put(Constants.CAR_COLOR, car.color)
        contentValues.put(Constants.CAR_BRAND, car.brand)
        contentValues.put(Constants.CAR_PRICE, car.price)
        database.insert(Constants.CAR_TABLE, null, contentValues)
        database.close()
    }

    override fun saveFootball(football: Football) {

    }

    override fun saveProg(programming: Programming) {

    }

    override fun getAllCars(): MutableList<Cars> {
        val database = this.readableDatabase
        val carList = ArrayList<Cars>()
        val query = "SELECT * FROM ${Constants.CAR_TABLE}"
        val cursor = database.rawQuery(query, null)
        if (cursor.moveToFirst()) {
            do {
                val car = Cars(
                    cursor.getInt(0),
                    cursor.getString(1),
                    cursor.getString(2),
                    cursor.getString(3),
                    cursor.getString(4)
                )
                carList.add(car)
            } while (cursor.moveToNext())
        }
        return carList
    }

    override fun getAllFootballs(): List<Football> {
        return emptyList()
    }

    override fun getAllProgs(): List<Programming> {
        return emptyList()
    }

    override fun deleteCar(carId: Int?) {
        val database = this.writableDatabase
        database.delete(Constants.CAR_TABLE, "${Constants.CAR_ID} = ?", arrayOf(carId.toString()))
        database.close()
    }

    override fun updateCar(car: Cars) {
        val database = this.writableDatabase
        val contentValues = ContentValues()
        contentValues.put(Constants.CAR_ID, car.id)
        contentValues.put(Constants.CAR_NAME, car.name)
        contentValues.put(Constants.CAR_COLOR, car.color)
        contentValues.put(Constants.CAR_BRAND, car.brand)
        contentValues.put(Constants.CAR_PRICE, car.price)
        database.update(
            Constants.CAR_TABLE,
            contentValues,
            "${Constants.CAR_ID} = ?",
            arrayOf(car.id.toString())
        )
    }

    override fun updateFootball(football: Football) {

    }

    override fun updateProg(programming: Programming) {

    }
}