package com.example.mifirstapp.todoapp.tasks

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.AdapterGeneric
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class TasksAdapter(private val tasks: List<Task>, private val onTaskSelected: (Int) -> Unit) : AdapterGeneric<Task>(tasks) {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderGeneric<Task> {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_todo_task, parent, false)
        return TasksViewHolder(view,onTaskSelected)
    }

    override fun onBindViewHolder(holder: ViewHolderGeneric<Task>, position: Int) {
        holder.render(tasks[position])
//        //itemview is all cell (container)
//        holder.itemView.setOnClickListener{
//            onTaskSelected(position)
//        }
//        val tasksViewHolder:TasksViewHolder = holder as TasksViewHolder
//        //ev click for checkbox
//        tasksViewHolder.cbTask.setOnClickListener {
//            onTaskSelected(position)
//        }
    }
}