package com.example.domain.usecase

import com.example.domain.model.ToDoData
import com.example.domain.repository.TodoRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOf
import javax.inject.Inject

class InsertDataUseCase @Inject constructor(
    private val repository: TodoRepository
) : UseCase<Unit, InsertDataUseCase.Params>() {

    override suspend fun run(params: Params): Flow<Unit> {
        repository.insertData(params.toDoData)
        return flowOf(Unit)
    }

    data class Params(val toDoData: ToDoData)
}






