package com.example.domain.repository

import androidx.room.Query
import com.example.domain.model.ToDoData
import kotlinx.coroutines.flow.Flow

interface TodoRepository {


    suspend fun insertData(toDoData: ToDoData)

    @Query("SELECT * FROM todo_table ORDER BY id ASC")
    suspend fun getAllData():Flow<List<ToDoData>>
}