package com.example.sqlwithmultipletable.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.sqlwithmultipletable.R
import com.example.sqlwithmultipletable.database.MyDatabase

class MainActivity : AppCompatActivity() {
    lateinit var myDatabase: MyDatabase
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        myDatabase = MyDatabase(this)


    }
}