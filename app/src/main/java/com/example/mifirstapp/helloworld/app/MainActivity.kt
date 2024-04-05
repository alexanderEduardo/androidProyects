package com.example.mifirstapp.helloworld.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.appcompat.widget.AppCompatButton
import androidx.appcompat.widget.AppCompatEditText
import com.example.mifirstapp.R

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val btnStart = findViewById<AppCompatButton>(R.id.search_go_btn)

        val editText1 = findViewById<AppCompatEditText>(R.id.editText1)


        btnStart.setOnClickListener {
            //Log.i(btnStart.id.toString(), "Button has been clicked $textBtn, edit text is ${editText1.text}")
            val editText = editText1.text.toString()
            if(editText.isNotEmpty()){
                btnStart.text = "button has been pulsed";
                btnStart.setBackgroundColor(
                    resources.getColor(
                        R.color.purple_500, resources.newTheme()
                    )
                )
                val intent = Intent(this,ResultActivity::class.java);
                intent.putExtra("EXTRA_NAME",editText)
                startActivity(intent)
            }else{
                Log.i("error","el texto del input esta vacio")
            }
        }
    }
}