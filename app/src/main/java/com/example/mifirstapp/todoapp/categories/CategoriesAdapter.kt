package com.example.mifirstapp.todoapp.categories

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mifirstapp.R
import com.example.mifirstapp.utils.AdapterGeneric
import com.example.mifirstapp.utils.ViewHolderGeneric

class CategoriesAdapter(private var categories: List<TaskCategory>, private val onCategorySelected: (Int)-> Unit) : AdapterGeneric<TaskCategory>(categories) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<TaskCategory> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view,onCategorySelected)
    }

    override fun getItemCount(): Int = categories.size

    override fun getList(): List<TaskCategory> = categories

    override fun setList(list: List<TaskCategory>) {
        categories = list
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<TaskCategory>, position: Int) {
        (holder as CategoriesViewHolder).render(categories[position])
    }

}