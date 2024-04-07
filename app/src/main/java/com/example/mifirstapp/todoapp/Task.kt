package com.example.mifirstapp.todoapp

data class Task (val name:String, val category: TaskCategory, var isSelected:Boolean = false)