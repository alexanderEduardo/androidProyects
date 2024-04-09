package com.example.mifirstapp.todoapp

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mifirstapp.R
import com.example.mifirstapp.todoapp.categories.CategoriesAdapter
import com.example.mifirstapp.todoapp.categories.TaskCategory
import com.example.mifirstapp.todoapp.tasks.Task
import com.example.mifirstapp.todoapp.tasks.TasksAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton
import java.text.FieldPosition

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
        Task("Prueba Other", TaskCategory.Other)
    )

    private lateinit var fabAddTask: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo)
        initComponents()
        initUI()
        initListeners()
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
                updateTask()
                dialog.hide()
            }
        }
    }

    private fun updateTask() {
        tasksAdapter.notifyItemInserted(tasksAdapter.getItemCount() + 1)
    }

    private fun initUI() {
        categoriesAdapter = CategoriesAdapter(categories)
        //scroll horizontal or vertical
        rvCategories.layoutManager =
            LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false)
        rvCategories.adapter = categoriesAdapter

        tasksAdapter = TasksAdapter(tasks, { position -> onItemSelected(position) })
        //vertical
        rvTasks.layoutManager = LinearLayoutManager(this)
        rvTasks.adapter = tasksAdapter
    }

    private fun onItemSelected(position: Int) {
        tasks[position].isSelected = !tasks[position].isSelected
        updateTask()
    }

    private fun initComponents() {
        rvCategories = findViewById(R.id.rvCategories)
        rvTasks = findViewById(R.id.rvTasks)
        fabAddTask = findViewById(R.id.btnAddTask)
    }


}