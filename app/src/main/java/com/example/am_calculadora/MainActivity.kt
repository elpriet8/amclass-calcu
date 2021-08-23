package com.example.am_calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView

// private const val TAG = "MainActivity"
class MainActivity : AppCompatActivity() {

    private lateinit var display : TextView
    private var userTyping = false

    private var num_a = 0 // primer operando
    private var num_b = 0 // segundo operando
    private var resultado = 0 // resultado
    private var mathSymbol = "" // Operacion en espera de operando

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        display = findViewById(R.id.display)
    }

    fun numberTapped(button: View){
        val num = (button as Button).text
        if(userTyping){
            display.append(num)
        }else{
            display.text = num
            userTyping = true
        }
    }

    fun operationTapped(button: View){
        val opPressed = (button as Button).text.toString()
        if(userTyping){
            num_b = display.text.toString().toInt()
            userTyping = false
        }

        resultado = execute_math(opPressed)
        display.text = resultado.toString()
    }

    fun execute_math(symbol : String) : Int{
        execute_wating_math()
        mathSymbol = symbol
        num_a = num_b
        return num_b
    }

    fun execute_wating_math(){
        when(mathSymbol){
            "+" -> num_b += num_a
            "-" -> num_b = num_a - num_b
            "X" -> num_b *= num_a
            "/" -> {
                if(num_b != 0){
                    num_b = num_a / num_b
                }
            }
        }
    }
}