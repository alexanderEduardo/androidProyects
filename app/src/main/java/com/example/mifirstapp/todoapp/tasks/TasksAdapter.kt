package com.example.mifirstapp.todoapp.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.AdapterGeneric
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class TasksAdapter(private var tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) : AdapterGeneric<Task>(tasks) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<Task> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view,onTaskSelected)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<Task>, position: Int) {
        holder.render(tasks[position])
    }
    override fun getList(): List<Task> {
        return tasks
    }

    override fun getItemCount() = tasks.size
    override fun setList(list: List<Task>) {
        tasks = list
    }

}