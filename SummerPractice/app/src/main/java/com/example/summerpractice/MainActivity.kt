package com.example.summerpractice

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var clickButton: Button? = null
    private var namePerson: EditText? = null
    private var age: EditText? = null
    private var height: EditText? = null
    private var weight: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        clickButton = findViewById<Button>(R.id.button)
        namePerson = findViewById<EditText>(R.id.editName)
        age = findViewById<EditText>(R.id.editAge)
        weight = findViewById<EditText>(R.id.editWeight)
        height = findViewById<EditText>(R.id.editHeight)
        val result = findViewById<TextView>(R.id.textView6)


        clickButton?.setOnClickListener {
            val name = namePerson?.text.toString()
            val heightString = height?.text.toString()
            val weightString = weight?.text.toString()
            val ageString = age?.text.toString()

            if (namePerson == null) {
                Toast.makeText(this, "Некорректные данные! Введите своё ФИО.", Toast.LENGTH_SHORT)
                    .show()
                return@setOnClickListener
            }

            val height = heightString.toIntOrNull()
            val weight = weightString.toFloatOrNull()
            val age = ageString.toIntOrNull()

            if (height == null || weight == null || age == null) {
                Toast.makeText(this, "Некорректные данные!", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (height <= 0 || height >= 250 || weight <= 0 || weight >= 250 || age <= 0 || age >= 150) {
                Toast.makeText(this, "Некорректные данные", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if(name != null && age>0 && age<150 && height>0 && height<250 && weight>0 && weight<250){

                val average = calculateAverage(height,weight)
                val mood = calculateMood(height,weight,age)
                val BMI = calculateBMI(height,weight)

                result.text = "Среднее значение: $average\nИндекс тела: $BMI\nНастроение от 0 до бесконечности: $mood"
            }
            }

    }

    private fun calculateBMI(height: Int, weight: Float): Any {
        return weight / (height * height)
    }

    private fun calculateMood(height: Int, weight: Float, age: Int): Any {
        return (height+weight+age)
    }

    private fun calculateAverage(height: Int, weight: Float): Any {
        return (height + weight) / 2
    }
}
