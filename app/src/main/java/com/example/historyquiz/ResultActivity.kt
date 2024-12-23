package com.example.historyquiz

import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class ResultActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val score = intent.getIntExtra("score", 0)
        val resultTextView: TextView = findViewById(R.id.resultTextView)
        val descriptionTextView: TextView = findViewById(R.id.descriptionTextView)
        val restartButton: Button = findViewById(R.id.restartButton)

        resultTextView.text = "Ваши баллы: $score"

        // Оценка знаний
        val description = when {
            score == 500 -> "Отличный знаток истории!"
            score >= 400 -> "Хороший знаток истории!"
            score >= 300 -> "Удовлетворительный уровень знаний."
            score >= 200 -> "Неплохой, но есть над чем поработать."
            else -> "Плохой уровень знаний. Рекомендуем повторить материал."
        }

        descriptionTextView.text = description

        restartButton.setOnClickListener {
            // Переход на главный экран
            finish() // Закрываем текущую активность
        }
    }
}