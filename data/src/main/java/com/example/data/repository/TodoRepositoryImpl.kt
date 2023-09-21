package com.example.data.repository

import com.example.data.db.dao.TodoDb
import com.example.domain.model.ToDoData
import com.example.domain.repository.TodoRepository
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepositoryImpl @Inject constructor(
    val todoDb:TodoDb
):TodoRepository {
    override suspend fun insertData(toDoData: ToDoData) {
        return todoDb.todoDao().insertData(toDoData)
    }
}