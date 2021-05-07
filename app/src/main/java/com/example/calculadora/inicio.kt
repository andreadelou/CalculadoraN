package com.example.calculadora

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button

class inicio : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)

        val inicio: Button = findViewById(R.id.inicio)

        inicio.setOnClickListener(){
            val intent: Intent = Intent (this,MainActivity::class.java)
            startActivity(intent)
            finish()
        }
    }
}