package com.example.presenter.ui

import com.example.domain.model.ToDoData
import com.example.presenter.R
import com.example.presenter.base.BaseAdapter
import com.example.presenter.databinding.ItemListBinding

class ListAdapter :BaseAdapter<ToDoData,ItemListBinding>(R.layout.item_list) {
    override fun onItemInflated(items: ToDoData, position: Int, binding: ItemListBinding) {
        binding.toDoData = items
    }
}