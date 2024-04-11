package com.example.mifirstapp.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.categories.CategoriesAdapter
import com.example.mifirstapp.todoapp.categories.TaskCategory
import com.example.mifirstapp.todoapp.tasks.Task
import com.example.mifirstapp.todoapp.tasks.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

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
    private val tasks = mutableListOf(
        Task("Prueba Business", TaskCategory.Business),
        Task("Prueba Personal", TaskCategory.Personal),
        Task("Prueba Other", TaskCategory.Other),
        Task("Prueba Business 1", TaskCategory.Business),
        Task("Prueba Personal 2", TaskCategory.Other),
        Task("Prueba Business 2", TaskCategory.Business),
        Task("Prueba Other 2", TaskCategory.Other),
        Task("Prueba Other 3", TaskCategory.Other),
    )

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListeners()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.btnAddTask)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories, {i -> onCategorySelected(i)})
        //scroll horizontal or vertical
        rvCategories.layoutManager = LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks, { position -> onTaskSelected(position) })
        //vertical
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun initListeners() {
        fabAddTask.setOnClickListener { showDialog() }
    }

    private fun showDialog() {
        val dialog = Dialog(this)
        dialog.setContentView(R.layout.dialog_task)
        dialog.show()
        val etTask: EditText = dialog.findViewById(R.id.etTask)
        val btnAddTask: Button = dialog.findViewById(R.id.btnAddTask)

        btnAddTask.setOnClickListener {
            if (etTask.text.isNotEmpty()) {
                val rgCategories: RadioGroup = dialog.findViewById(R.id.rgCategories)
                val selectedId = rgCategories.checkedRadioButtonId
                val radioBtnSelected: RadioButton = rgCategories.findViewById(selectedId)
                val taskSelected: TaskCategory = when (radioBtnSelected.text) {
                    getString(R.string.todoapp_business) -> TaskCategory.Business
                    getString(R.string.todoapp_personal) -> TaskCategory.Personal
                    getString(R.string.todoapp_other) -> TaskCategory.Other
                    else -> TaskCategory.Other
                }

                tasks.add(Task(etTask.text.toString(), taskSelected))
                insertTask()
                dialog.hide()
            }
        }
    }

    private fun insertTask() {
        tasksAdapter.notifyItemInserted(tasksAdapter.getItemCount() + 1)
    }

    private fun updateTask(position: Int) {
        tasksAdapter.notifyItemChanged(position)
    }

    private fun deleteTask(position: Int) {
        tasksAdapter.notifyItemRemoved(position)
    }

    private fun onTaskSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask(position)
    }

    private fun onCategorySelected(position: Int) {
        val categorySelected = categories[position]
        categorySelected.isSelected = !categorySelected.isSelected
        categoriesAdapter.notifyItemChanged(position)
        val categoriesSelected = categories.filter { !it.isSelected }
        tasks.forEach { task ->
            task.isVisible = !categoriesSelected.contains(task.category)
            updateTask(tasks.indexOf(task))
        }
    }

}