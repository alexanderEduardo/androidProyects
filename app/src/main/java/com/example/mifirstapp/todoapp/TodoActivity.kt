package com.example.mifirstapp.todoapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.categories.CategoriesAdapter
import com.example.mifirstapp.todoapp.categories.TaskCategory
import com.example.mifirstapp.todoapp.tasks.Task
import com.example.mifirstapp.todoapp.tasks.TasksAdapter

class TodoActivity : AppCompatActivity() {

    private lateinit var rvCategories: RecyclerView
    private lateinit var categoriesAdapter: CategoriesAdapter
    private val categories = listOf(
        TaskCategory.Business,
        TaskCategory.Other,
        TaskCategory.Personal
    )

    private lateinit var tasksAdapter: TasksAdapter
    private lateinit var rvTasks: RecyclerView
    private val tasks = mutableListOf<Task>(
        Task("Prueba Business",TaskCategory.Business),
        Task("Prueba Personal",TaskCategory.Personal),
        Task("Prueba Other",TaskCategory.Other)
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        //scroll horizontal or vertical
        rvCategories.layoutManager = LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks)
        //vertical
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
    }


}