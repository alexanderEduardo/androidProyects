package com.example.mifirstapp.todoapp

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.mifirstapp.R

class CategoriesAdapter(private val categories: List<TaskCategory>): RecyclerView.Adapter<CategoriesViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoriesViewHolder {
        //Crea una vista y montar esa vista(ex card)
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_task_category, parent, false)
        return CategoriesViewHolder(view)
    }

    override fun onBindViewHolder(holder: CategoriesViewHolder, position: Int) {
        //this method passed the data to the view
        holder.render(categories[position])
    }
    override fun getItemCount(): Int = categories.size
}