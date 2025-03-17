package com.valdez.buttons

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.CheckBox
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.enableEdgeToEdge

class MainActivity : ComponentActivity() {
    private lateinit var textTitle: TextView
    private lateinit var checkboxMale: CheckBox
    private lateinit var checkboxFemale: CheckBox
    private lateinit var checkboxOthers: CheckBox
    private lateinit var buttonSubmit: Button

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        textTitle = findViewById(R.id.text_title)
        checkboxMale = findViewById(R.id.checkbox_male)
        checkboxFemale = findViewById(R.id.checkbox_female)
        checkboxOthers = findViewById(R.id.checkbox_others)
        buttonSubmit = findViewById(R.id.button_submit)

        checkboxMale.setOnClickListener {
            if (checkboxMale.isChecked) {
                textTitle.text = "Your gender is male"
            } else {
                textTitle.text = "Choose your gender"
            }
        }

        checkboxFemale.setOnClickListener {
            if (checkboxFemale.isChecked) {
                textTitle.text = "Your gender is female"
            } else {
                textTitle.text = "Choose your gender"
            }
        }

        checkboxOthers.setOnClickListener {
            if (checkboxOthers.isChecked) {
                textTitle.text = "You prefer not to say it"
            } else {
                textTitle.text = "Choose your gender"
            }
        }

        buttonSubmit.setOnClickListener {
            val intent = Intent(this, SecondActivity::class.java)
            startActivity(intent)
        }
    }
}
