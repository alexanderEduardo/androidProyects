package com.example.mifirstapp.todoapp.categories

import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class CategoriesViewHolder(view:View): ViewHolderGeneric<TaskCategory>(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.categoryName)
    private val divider: View = view.findViewById(R.id.divider)
    override fun render(dataRv: TaskCategory) {
        when(dataRv){
            TaskCategory.Business -> {
                tvCategoryName.text = "Negocios"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.todo_business_category)
                )
            }
            TaskCategory.Other -> {
                tvCategoryName.text = "Otros"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.todo_other_category)
                )
            }
            TaskCategory.Personal -> {
                tvCategoryName.text = "Personal"
                divider.setBackgroundColor(
                    ContextCompat.getColor(divider.context,R.color.todo_personal_category)
                )
            }
        }
    }
}