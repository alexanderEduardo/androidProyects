package com.example.mifirstapp.todoapp.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.AdapterGeneric
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class TasksAdapter(private val tasks: List<Task>) : AdapterGeneric<Task>(tasks) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<Task> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<Task>, position: Int) {
        holder.render(tasks[position])
    }
}