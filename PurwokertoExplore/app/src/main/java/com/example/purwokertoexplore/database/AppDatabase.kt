package com.example.purwokertoexplore.database

import androidx.room.Database
import com.example.purwokertoexplore.model.ModelDatabase
import androidx.room.RoomDatabase
import com.example.purwokertoexplore.database.dao.DatabaseDao



@Database(entities = [ModelDatabase::class], version = 1, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun databaseDao(): DatabaseDao?
}