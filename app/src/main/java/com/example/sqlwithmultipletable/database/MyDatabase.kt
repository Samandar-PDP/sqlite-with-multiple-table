package com.example.sqlwithmultipletable.database

import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper
import com.example.sqlwithmultipletable.model.Cars
import com.example.sqlwithmultipletable.model.Football
import com.example.sqlwithmultipletable.model.Programming
import com.example.sqlwithmultipletable.utils.Constants

class MyDatabase(context: Context): SQLiteOpenHelper(context, Constants.DB_NAME, null, Constants.DB_VERSION), DatabaseService {
    override fun onCreate(db: SQLiteDatabase?) {
        val carQuery = "CREATE TABLE ${Constants.CAR_TABLE}(${Constants.CAR_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.CAR_NAME} TEXT NOT NULL, ${Constants.CAR_BRAND} TEXT NOT NULL, ${Constants.CAR_COLOR} TEXT NOT NULL  , ${Constants.CAR_PRICE} TEXT NOT NULL)"
        val progQuery = "CREATE TABLE ${Constants.PROG_TABLE}(${Constants.PROG_ID} INTEGER NOT NULL PRIMARY KEY AUTOINCREMENT UNIQUE, ${Constants.PROG_NAME} TEXT NOT NULL, ${Constants.PROG_DATE} TEXT NOT NULL, ${Constants.PROG_WHAT} TEXT NOT NULL)"


        db?.execSQL(progQuery)
        db?.execSQL(carQuery)
    }

    override fun onUpgrade(p0: SQLiteDatabase?, p1: Int, p2: Int) {

    }

    override fun saveCar(cars: Cars) {

    }

    override fun saveFootball(football: Football) {

    }

    override fun saveProg(programming: Programming) {

    }

    override fun getAllCars(): List<Cars> {

    }

    override fun getAllFootballs(): List<Football> {

    }

    override fun getAllProgs(): List<Programming> {

    }
}