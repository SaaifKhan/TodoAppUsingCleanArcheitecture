package com.example.presenter.base

import android.view.View
import androidx.cardview.widget.CardView
import androidx.databinding.BindingAdapter
import androidx.lifecycle.MutableLiveData
import androidx.navigation.findNavController
import com.example.domain.model.Priority
import com.example.presenter.R
import com.google.android.material.floatingactionbutton.FloatingActionButton

@BindingAdapter("android:navigateToAddFragment")
fun navigateToAddFragment(view: FloatingActionButton, navigate: Boolean){
    view.setOnClickListener {
        if(navigate){
            view.findNavController().navigate(R.id.action_listFragment_to_insertFragment)
        }
    }
}

@BindingAdapter("android:parsePriorityColor")
fun parsePriorityColor(cardView: CardView, priority: Priority){
    when(priority){
        Priority.HIGH -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.red)) }
        Priority.MEDIUM -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.yellow)) }
        Priority.LOW -> { cardView.setCardBackgroundColor(cardView.context.getColor(R.color.green)) }
    }


}

@BindingAdapter("android:emptyDatabase")
fun emptyDatabase(view: View, emptyDatabase: MutableLiveData<Boolean>){
    when(emptyDatabase.value){
        true -> view.visibility = View.VISIBLE
        false -> view.visibility = View.INVISIBLE
        else -> {}
    }
}