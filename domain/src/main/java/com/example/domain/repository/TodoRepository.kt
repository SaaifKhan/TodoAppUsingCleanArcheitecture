package com.example.domain.repository

import androidx.room.Query
import com.example.domain.model.ToDoData
import kotlinx.coroutines.flow.Flow

interface TodoRepository {


    suspend fun insertData(toDoData: ToDoData)

    suspend fun getAllData():Flow<List<ToDoData>>

    suspend fun search(query:String) : Flow<List<ToDoData>>
}