package com.example.data.db.dao

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.domain.model.ToDoData

@Database(
    entities = [ToDoData::class],
    version = 1,
    exportSchema = false
)
abstract class TodoDb : RoomDatabase(){

    abstract fun todoDao(): TodoAppDao

}