package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.widget.Button

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val startButton: Button = findViewById(R.id.startButton)
        startButton.setOnClickListener {
            // Переход на экран с вопросами
            val intent = Intent(this, QuestionActivity::class.java)
            intent.putExtra("score", 0) // Начальный счет
            startActivity(intent)
        }
    }
}