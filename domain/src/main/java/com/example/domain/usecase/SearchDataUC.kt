package com.example.domain.usecase

import com.example.domain.model.ToDoData
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class SearchDataUC @Inject constructor(
    private val repository: TodoRepository
): UseCase<List<ToDoData>, String>() {
    override suspend fun run(params: String): Flow<List<ToDoData>> {
        return repository.search(params)
    }
}