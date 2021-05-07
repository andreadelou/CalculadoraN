package com.example.calculadora

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.roundToLong
//
class MainActivity : AppCompatActivity() {

    private var num1 = 0.0
    private var num2 = 0.0
    private var operacion = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        uno.setOnClickListener {numeropresionado("1")}
        dos.setOnClickListener {numeropresionado("2")}
        tres.setOnClickListener {numeropresionado("3")}
        cuatro.setOnClickListener {numeropresionado("4")}
        cinco.setOnClickListener {numeropresionado("5")}
        seis.setOnClickListener {numeropresionado("6")}
        siete.setOnClickListener {numeropresionado("7")}
        ocho.setOnClickListener {numeropresionado("8")}
        nueve.setOnClickListener {numeropresionado("9")}
        cero.setOnClickListener {numeropresionado("0")}

        clear.setOnClickListener { resetAll() }

        sumar.setOnClickListener { operationPressed(SUMA) }
        resta.setOnClickListener { operationPressed(RESTA) }
        multiplicar.setOnClickListener { operationPressed(MULTIPLICACION) }
        division.setOnClickListener { operationPressed(DIVISION) }

        igual.setOnClickListener { resolvePressed() }

    }

    private fun numeropresionado(num: String)
    {
        if(resultado.text == "0" && num != ".") {
            resultado.text = "$num"
        } else {
            resultado.text = "${resultado.text}$num"
        }

        if(operacion == SIN_OPERACION){
            num1 = resultado.text.toString().toDouble()
        } else {
            num2 = resultado.text.toString().toDouble()
        }
    }

    private fun operationPressed(operacion: Int){
        this.operacion = operacion
        num1 = resultado.text.toString().toDouble()

        resultado.text = "0"
    }

    private fun resolvePressed(){

        val result = when(operacion) {
            SUMA -> num1 + num2
            RESTA -> num1 - num2
            MULTIPLICACION -> num1 * num2
            DIVISION -> num1 / num2
            else -> 0
        }

        num1 = result as Double

        resultado.text = if("$result".endsWith(".0")) { "$result".replace(".0","") } else { "%.2f".format(result) }
    }

    private fun resetAll(){
        resultado.text = "0"
        num1 = 0.0
        num2 = 0.0
    }

    companion object {
        const val SUMA = 1
        const val RESTA = 2
        const val MULTIPLICACION = 3
        const val DIVISION = 4
        const val SIN_OPERACION = 0
    }
}