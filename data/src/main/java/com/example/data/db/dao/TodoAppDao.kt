package com.example.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.domain.model.ToDoData

@Dao
interface TodoAppDao {
    @Insert(onConflict = OnConflictStrategy.IGNORE)
    suspend fun insertData(toDoData: ToDoData)


    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    fun getAllData(): ToDoData


}