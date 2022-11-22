package com.app.library

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.room.Room
import com.app.mylibrary.AppDatabase

class MainActivity : AppCompatActivity() {
    lateinit var dataBase : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


            dataBase = Room.databaseBuilder(
                this,
                AppDatabase::class.java, "DataUrl"
            ).build()
        dataBase.dataUrlDao()
    }



}