package com.example.mifirstapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.mifirstapp.helloworld.app.MainActivity
import com.example.mifirstapp.imc.app.ImcCalculatorActivity
import com.example.mifirstapp.superhero.app.SuperHeroListActivity
import com.example.mifirstapp.todoapp.TodoActivity

class MenuActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_menu)

        val btnHelloApp = findViewById<Button>(R.id.btnHelloApp)
        btnHelloApp.setOnClickListener{
            navigateToHelloApp()
        }

        val btnIMCApp = findViewById<Button>(R.id.btnIMCApp)
        btnIMCApp.setOnClickListener{
            navigateToIMCApp()
        }

        val btnTodoApp = findViewById<Button>(R.id.btnTodoApp)
        btnTodoApp.setOnClickListener{
            navigateToTodoapp()
        }

        val btnSuperHeroApp = findViewById<Button>(R.id.btnSuperHeroApp)
        btnSuperHeroApp.setOnClickListener{
            navigateToSuperHeroApp()
        }
    }

    private fun navigateToSuperHeroApp() {
        val intent = Intent(this, SuperHeroListActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToTodoapp() {
        val intent = Intent(this, TodoActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToIMCApp() {
        val intent = Intent(this, ImcCalculatorActivity::class.java)
        startActivity(intent)
    }

    private fun navigateToHelloApp(){
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }
}