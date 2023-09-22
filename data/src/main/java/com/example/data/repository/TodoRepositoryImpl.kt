package com.example.data.repository

import com.example.data.db.dao.TodoDb
import com.example.domain.model.ToDoData
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TodoRepositoryImpl @Inject constructor(
    val todoDb:TodoDb
):TodoRepository {
    override suspend fun insertData(toDoData: ToDoData) {
        return todoDb.todoDao().insertData(toDoData)
    }

    override suspend fun getAllData(): Flow<List<ToDoData>> {
        return  todoDb.todoDao().getAllData()
    }

    override suspend fun search(query: String): Flow<List<ToDoData>> {
        return todoDb.todoDao().searchDatabase(query)
    }
}