package com.example.presenter.ui

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.domain.model.Priority
import com.example.domain.model.ToDoData
import com.example.domain.usecase.InsertDataUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class InsertViewModel @Inject constructor(
    private val insertDataUseCase: InsertDataUseCase
):ViewModel() {


    var request = ToDoData(0,"",null,"")

     fun insertData(){
        viewModelScope.launch {
            insertDataUseCase.run(InsertDataUseCase.Params(request))
                .onStart {  }
                .onCompletion {

                }
                .catch {  }
                .collectLatest {

                }
        }
    }


    fun verifyDataFromUser(title: String, description: String): Boolean {
        return !(title.isEmpty() || description.isEmpty())
    }
    fun parsePriority(priority: String): Priority {
        return when(priority){
            "High Priority" -> { Priority.HIGH }
            "Medium Priority" -> { Priority.MEDIUM }
            "Low Priority" -> { Priority.LOW }
            else -> Priority.LOW
        }
    }
}