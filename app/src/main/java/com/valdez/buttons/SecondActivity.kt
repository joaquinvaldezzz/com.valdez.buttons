package com.valdez.buttons

import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.ScrollView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class SecondActivity : AppCompatActivity() {
    private lateinit var layoutScrollView: ScrollView
    private var radioButtonColorMap = mapOf(
        R.id.radiobutton_red to R.color.red,
        R.id.radiobutton_orange to R.color.orange,
        R.id.radiobutton_amber to R.color.amber,
        R.id.radiobutton_yellow to R.color.yellow,
        R.id.radiobutton_lime to R.color.lime,
        R.id.radiobutton_green to R.color.green,
        R.id.radiobutton_emerald to R.color.emerald,
        R.id.radiobutton_teal to R.color.teal,
        R.id.radiobutton_cyan to R.color.cyan,
        R.id.radiobutton_sky to R.color.sky,
        R.id.radiobutton_blue to R.color.blue,
        R.id.radiobutton_violet to R.color.violet,
        R.id.radiobutton_purple to R.color.purple,
        R.id.radiobutton_fuchsia to R.color.fuchsia
    )
    private lateinit var buttonChange: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_second)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.activity_second)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        layoutScrollView = findViewById(R.id.activity_second)
        buttonChange = findViewById(R.id.button_change)

        buttonChange.setOnClickListener {
            val selectedRadioButton =
                radioButtonColorMap.keys.mapNotNull { findViewById<RadioButton>(it) }
                    .firstOrNull { it.isChecked }

            selectedRadioButton?.let {
                val colorId = radioButtonColorMap[it.id]
                colorId?.let { color ->
                    layoutScrollView.setBackgroundColor(ContextCompat.getColor(this, color))
                }
            }
        }
    }
}
