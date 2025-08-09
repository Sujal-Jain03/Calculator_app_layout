package com.example.calculator

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var result_textview: TextView   // this only used for initialization of a variable
    private lateinit var previous_calculation_textview: TextView
    private var operation=""   // this used for initialization and declaration of a variable
    private var first_number = 0.0
    private var is_new_operation = true
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        result_textview =findViewById(R.id.resultTextView)
        previous_calculation_textview=findViewById(R.id.calculationTextView)
        val button0: Button = findViewById(R.id.btn0)
        val button1: Button = findViewById(R.id.btn1)
        val button2: Button = findViewById(R.id.btn2)
        val button3: Button = findViewById(R.id.btn3)
        val button4: Button = findViewById(R.id.btn4)
        val button5: Button = findViewById(R.id.btn5)
        val button6: Button = findViewById(R.id.btn6)
        val button7: Button = findViewById(R.id.btn7)
        val button8: Button = findViewById(R.id.btn8)
        val button9: Button = findViewById(R.id.btn9)

        val buttonPlus: Button = findViewById(R.id.btnPlus)
        val buttonMinus: Button = findViewById(R.id.btnMinus)
        val buttonMultiply: Button = findViewById(R.id.btnMultiply)
        val buttonDivide: Button = findViewById(R.id.btnDivide)
        val buttonPercent: Button = findViewById(R.id.btnPercent)

        val buttonEqual: Button = findViewById(R.id.btnEqual)
        val buttonClear: Button = findViewById(R.id.btnClear)
        val buttonBackspace: Button = findViewById(R.id.btnBackspace)


        val buttonDot: Button = findViewById(R.id.btnDot)

//        Number button click listeners
        button0.setOnClickListener { appendnumber("0") }
        button1.setOnClickListener { appendnumber("1") }
        button2.setOnClickListener { appendnumber("2") }
        button3.setOnClickListener { appendnumber("3") }
        button4.setOnClickListener { appendnumber("4") }
        button5.setOnClickListener { appendnumber("5") }
        button6.setOnClickListener { appendnumber("6") }
        button7.setOnClickListener { appendnumber("7") }
        button8.setOnClickListener { appendnumber("8") }
        button9.setOnClickListener { appendnumber("9") }
        buttonDot.setOnClickListener { appendnumber(".") }

        buttonPlus.setOnClickListener{setoperation("+")}
        buttonMinus.setOnClickListener{setoperation("-")}
        buttonMultiply.setOnClickListener{setoperation("*")}
        buttonDivide.setOnClickListener{setoperation("÷")}
        buttonPercent.setOnClickListener{setoperation("%")}

        buttonEqual.setOnClickListener{calculator_result()}
        buttonClear.setOnClickListener{calculator_clear()}
        buttonBackspace.setOnClickListener{calculator_backspace()}

    }

    @SuppressLint("SetTextI18n")
    private fun appendnumber(number:String){
        if (is_new_operation){
            result_textview.text=number
            is_new_operation=false
        }
        else{
            result_textview.text="${result_textview.text}$number"
        }

    }
    @SuppressLint("SetTextI18n")
    private fun setoperation(op:String){
        first_number=result_textview.text.toString().toDouble()
        operation=op
        is_new_operation=true
        previous_calculation_textview.text="$first_number $operation"


    }
    @SuppressLint("SetTextI18n")
    private fun calculator_result(){
        try{
            val second_number = result_textview.text.toString().toDouble()
            val result:Double =when(operation){
                "+" -> first_number+second_number
                "-" -> first_number-second_number
                "*" -> first_number*second_number
                "÷" -> first_number/second_number
                "%" -> first_number%second_number
                else -> second_number
            }
            previous_calculation_textview.text = "$first_number $operation $second_number ="
            result_textview.text=result.toString()
            is_new_operation=true
        }
        catch (e: Exception){
            result_textview.text="Error"
        }
    }
    private fun calculator_clear(){
        result_textview.text="0"
        operation=""
        is_new_operation=true
        previous_calculation_textview.text=""

    }
    private fun calculator_backspace(){
        val curr_text=result_textview.text.toString()
        if (curr_text.isNotEmpty()){
            result_textview.text=curr_text.dropLast(1)

        }
    }






}