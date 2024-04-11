package com.example.mifirstapp.todoapp.categories

import android.util.Log
import android.view.View
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.ViewHolderGeneric

class CategoriesViewHolder(view:View, onCategorySelected: (Int)-> Unit): ViewHolderGeneric<TaskCategory>(view) {

    private val tvCategoryName: TextView = view.findViewById(R.id.categoryName)
    private val divider: View = view.findViewById(R.id.divider)
    private val currentCardView = itemView as CardView;
    init {
        Log.i("CategoriesViewHolder view reference", "itemView === view => ${itemView === view}")
        itemView.setOnClickListener {
            onCategorySelected(layoutPosition)
        }
    }
    override fun render(dataRv: TaskCategory) {


        val color = if (dataRv.isSelected) {
            R.color.todo_background_card
        } else {
            R.color.todo_background_disabled
        }

        currentCardView.setCardBackgroundColor(ContextCompat.getColor(currentCardView.context, color))

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