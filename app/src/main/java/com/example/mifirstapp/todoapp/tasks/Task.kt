package com.example.mifirstapp.todoapp.tasks

import com.example.mifirstapp.todoapp.categories.TaskCategory

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)