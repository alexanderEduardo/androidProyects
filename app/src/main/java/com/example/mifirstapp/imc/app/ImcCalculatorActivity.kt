package com.example.mifirstapp.imc.app

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.compose.runtime.currentRecomposeScope
import androidx.core.content.ContextCompat
import com.example.mifirstapp.R
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.slider.RangeSlider
import java.text.DecimalFormat

class ImcCalculatorActivity : AppCompatActivity() {

    private lateinit var viewMale:CardView
    private lateinit var viewFemale:CardView
    private lateinit var tvHeight:TextView
    private lateinit var rsHeight:RangeSlider
    private lateinit var btnDecreaseWeight:FloatingActionButton
    private lateinit var btnIncreaseWeight:FloatingActionButton
    private lateinit var tvWeight:TextView
    private lateinit var btnDecreaseAge:FloatingActionButton
    private lateinit var btnIncreaseAge:FloatingActionButton
    private lateinit var tvAge:TextView
    private var currentWeight:Int = 60
    private var currentAge:Int = 21;
    //private val viewMale: CardView by lazy { findViewById(R.id.viewMale) }
    //private val viewFemale: CardView by lazy { findViewById(R.id.viewFemale) }

    private var selectedGender: Gender = Gender.MALE

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_imc_calculator)
        initComponents()
        initListeners()
        initUI()
    }

    private fun initUI() {
        setWeight()
        setAge()
    }

    private fun setAge() {
        tvAge.text = currentAge.toString()
    }

    private fun initComponents(){
        viewMale = findViewById(R.id.viewMale)
        viewFemale = findViewById(R.id.viewFemale)
        tvHeight = findViewById(R.id.tvHeight)
        rsHeight =findViewById(R.id.rsHeight)
        btnDecreaseWeight = findViewById(R.id.btnDecreaseWeight)
        btnIncreaseWeight = findViewById(R.id.btnIncreaseWeight)
        tvWeight = findViewById(R.id.tvWeight)
        btnDecreaseAge = findViewById(R.id.btnDecreaseAge)
        btnIncreaseAge = findViewById(R.id.btnIncreaseAge)
        tvAge = findViewById(R.id.tvAge)
    }

    private fun initListeners() {
        viewMale.setOnClickListener {setGenderColor(Gender.MALE)}
        viewFemale.setOnClickListener {setGenderColor(Gender.FEMALE)}
        rsHeight.addOnChangeListener { _, value, _ ->
            val df = DecimalFormat("#.##")
            val result = df.format(value)
            tvHeight.text = "$result cm"
        }

        btnDecreaseWeight.setOnClickListener{
            if (currentWeight > 1) {
                currentWeight--
                setWeight()
            }
        }

        btnIncreaseWeight.setOnClickListener{
            currentWeight++
            setWeight()
        }

        btnDecreaseAge.setOnClickListener{
            if (currentAge > 1){
                currentAge--
                setAge()
            }
        }

        btnIncreaseAge.setOnClickListener{
            currentAge++
            setAge()
        }
    }

    private fun setWeight() {
        tvWeight.text = currentWeight.toString()
    }

    private fun setGenderColor(gender: Gender){
        val bgComponent = ContextCompat.getColor(this,R.color.background_component)
        val bgComponentSelected = ContextCompat.getColor(this,R.color.background_component_selected)
        when (gender) {
            Gender.MALE -> {
                viewMale.setCardBackgroundColor(bgComponentSelected)
                viewFemale.setCardBackgroundColor(bgComponent)
                selectedGender = Gender.MALE
            }
            Gender.FEMALE -> {
                viewMale.setCardBackgroundColor(bgComponent)
                viewFemale.setCardBackgroundColor(bgComponentSelected)
                selectedGender = Gender.FEMALE
            }
        }
    }
}

enum class Gender {
    MALE, FEMALE
}
