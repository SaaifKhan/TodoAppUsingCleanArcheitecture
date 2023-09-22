package com.example.presenter.ui

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.data.db.dao.TodoDb
import com.example.domain.model.ToDoData
import com.example.domain.usecase.GetAllDataUC
import com.example.domain.usecase.SearchDataUC
import com.example.domain.usecase.UseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.onCompletion
import kotlinx.coroutines.flow.onStart
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ListViewModel @Inject constructor(
    private val uc: GetAllDataUC,
    val todoDb: TodoDb,
    private val searchDataUC: SearchDataUC


) : ViewModel() {

    private val _dataState: MutableStateFlow<List<ToDoData>> = MutableStateFlow(emptyList())
    val dataState: StateFlow<List<ToDoData>> = _dataState


    private val _dataStateAfterSearch: MutableStateFlow<List<ToDoData>> = MutableStateFlow(emptyList())
    val dataStateSearched: StateFlow<List<ToDoData>> = _dataStateAfterSearch


    init {
        getList()
    }


    fun getList(){
        viewModelScope.launch {
            todoDb.todoDao().getAllData()
                .onStart {
                    Log.d("viewmode","$this")

                }
                .catch {
                    Log.d("viewmode","${it.message}")

                }
                .collectLatest {
                   Log.d("viewmode","$it")
                    _dataState.value = it
                }
        }
    }

    val emptyDatabase: MutableLiveData<Boolean> = MutableLiveData(false)

    fun checkIfDatabaseEmpty(toDoData: List<ToDoData>){
        emptyDatabase.value = toDoData.isEmpty()
    }

    fun searchData(query:String){
        viewModelScope.launch {
            searchDataUC(query)
                .onStart {

                }
                .catch {

                }
                .collect{
                    _dataStateAfterSearch.value = it
                }
        }
    }

}