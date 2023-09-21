package com.example.domain.repository

import com.example.domain.model.ToDoData

interface TodoRepository {


    suspend fun insertData(toDoData: ToDoData)
}