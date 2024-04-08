package com.example.mifirstapp.todoapp.tasks

import android.view.View
import android.widget.CheckBox
import android.widget.TextView
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class TasksViewHolder(view: View): ViewHolderGeneric<Task>(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)
    override fun render(dataRv: Task) {
        tvTask.text = dataRv.name
    }
}