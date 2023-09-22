package com.example.domain.usecase

import com.example.domain.model.ToDoData
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class GetAllDataUC @Inject constructor(
    private val repository: TodoRepository
) : UseCase<List<ToDoData>, UseCase.None>() {
    override suspend fun run(params: None): Flow<List<ToDoData>> =
        repository.getAllData()
}