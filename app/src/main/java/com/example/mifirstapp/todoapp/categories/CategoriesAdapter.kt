package com.example.mifirstapp.todoapp.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.AdapterGeneric
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class CategoriesAdapter(private val categories: List<TaskCategory>) : AdapterGeneric<TaskCategory>(categories) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<TaskCategory> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<TaskCategory>, position: Int) {
        //this method passed the data to the view
        holder.render(categories[position])
    }
}