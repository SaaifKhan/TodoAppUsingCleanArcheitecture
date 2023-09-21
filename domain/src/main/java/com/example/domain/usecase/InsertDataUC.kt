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
        // Insert data into the Room database using the repository
        repository.insertData(params.toDoData)
        // Return a flow with a result indicating success
        return flowOf(Unit)
    }

    data class Params(val toDoData: ToDoData)
}






