package com.example.mifirstapp.imc.app

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.core.content.ContextCompat
import com.example.mifirstapp.R
import com.example.mifirstapp.imc.app.ImcCalculatorActivity.Companion.IMC_KEY

class ResultIMCActivity : AppCompatActivity() {

    private lateinit var tvResult: TextView
    private lateinit var tvIMC: TextView
    private lateinit var tvDescription: TextView
    private lateinit var btnReCalculate: Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result_imcactivity)
        /*
        if none have been added in the extra map then result is eq to -1.0f
        else result can be the true value of the extra map with the specific key
        but if the key doesn't exist in the map the default value is 0.0f
        */
        val imcValue:Float = intent.extras?.getFloat(IMC_KEY) ?: -1.0f
        Log.i("imc","the result is $imcValue")
        initComponents()
        initUI(imcValue)
        initListeners()
    }

    private fun initListeners() {
        btnReCalculate.setOnClickListener{
            onBackPressed()
            /*val intent = Intent(this,ImcCalculatorActivity::class.java)
            startActivity(intent)*/
        }
    }

    private fun initUI(imcValue: Float) {
        tvIMC.text = imcValue.toString()
        when(imcValue){
            0.0f,-1.0f -> { //error
                print("Generic Error")
            }
            in 0.01f..18.50f ->{ //bajo peso
                tvResult.text = getString(R.string.title_low_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.low_weight))
                tvDescription.text = getString(R.string.desc_low_weight)
            }
            in 18.51f..24.99f ->{ //peso normal
                tvResult.text = getString(R.string.title_normal_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.normal_weight))
                tvDescription.text = getString(R.string.desc_normal_weight)
            }
            in 25f..29.99f ->{ //sobrepeso
                tvResult.text = getString(R.string.title_over_weight)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.overweight))
                tvDescription.text = getString(R.string.desc_over_weight)
            }
            in 30f..99f ->{ //obesidad
                tvResult.text = getString(R.string.title_obesity)
                tvResult.setTextColor(ContextCompat.getColor(this,R.color.obesity))
                tvDescription.text = getString(R.string.desc_obesity)
            }
        }
    }

    private fun initComponents() {
        tvIMC = findViewById(R.id.tvIMC)
        tvResult = findViewById(R.id.tvResult)
        tvDescription = findViewById(R.id.tvDescription)
        btnReCalculate = findViewById(R.id.btnReCalculate)
    }




}