package com.example.mifirstapp.todoapp.tasks

import android.content.res.ColorStateList
import android.graphics.Color
import android.graphics.Paint
import android.view.View
import android.view.ViewGroup
import android.widget.CheckBox
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.ViewHolderGeneric
import com.example.mifirstapp.todoapp.categories.TaskCategory

class TasksViewHolder(private val view: View, onTaskSelected: (Int)-> Unit) : ViewHolderGeneric<Task>(view) {
    private val tvTask: TextView = view.findViewById(R.id.tvTask)
    private val cbTask: CheckBox = view.findViewById(R.id.cbTask)

    init {
        itemView.setOnClickListener{
            onTaskSelected(adapterPosition)
        }
        cbTask.setOnClickListener {
            onTaskSelected(adapterPosition)
        }
    }

    override fun render(dataRv: Task) {

        cbTask.isChecked = dataRv.isSelected
        tvTask.text = dataRv.name

        if (dataRv.isVisible) {
            itemView.visibility = View.VISIBLE
            val params = itemView.layoutParams
            params.height = ViewGroup.LayoutParams.WRAP_CONTENT
            itemView.layoutParams = params
        } else {
            itemView.visibility = View.GONE
            val params = itemView.layoutParams
            params.height = 0
            itemView.layoutParams = params
        }

        if (dataRv.isSelected) {
            tvTask.paintFlags = tvTask.paintFlags or Paint.STRIKE_THRU_TEXT_FLAG
        } else {
            tvTask.paintFlags = tvTask.paintFlags and Paint.STRIKE_THRU_TEXT_FLAG.inv()
        }

        val checkBoxColor = when (dataRv.category) {
            TaskCategory.Business -> R.color.todo_business_category
            TaskCategory.Other -> R.color.todo_other_category
            TaskCategory.Personal -> R.color.todo_personal_category
        }

        cbTask.buttonTintList = ColorStateList.valueOf(ContextCompat.getColor(view.context, checkBoxColor))

    }

}