package com.app.mylibrary

import androidx.room.RoomDatabase


@androidx.room.Database(entities = [DataUrl::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun dataUrlDao(): DataUrlDao
}