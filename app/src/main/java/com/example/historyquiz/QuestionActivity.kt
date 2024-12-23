package com.example.historyquiz

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class QuestionActivity : AppCompatActivity() {

    private var currentQuestionIndex = 0
    private var score = 0

    private val questions = arrayOf(
        "Какой год считается годом основания Москвы?",
        "Кто был первым президентом России?",
        "Какое событие произошло в 1812 году?",
        "Кто написал 'Медного всадника'?",
        "Когда началась Великая Отечественная война?"
    )

    private val answers = arrayOf(
        arrayOf("1147", "1237", "1453"), // Варианты ответов для первого вопроса
        arrayOf("Борис Ельцин", "Владимир Путин", "Михаил Горбачев"), // Второй вопрос
        arrayOf("Отечественная война", "Гражданская война", "Первая мировая война"), // Третий вопрос
        arrayOf("Александр Пушкин", "Лев Толстой", "Федор Достоевский"), // Четвертый вопрос
        arrayOf("1941", "1945", "1940") // Пятый вопрос
    )

    private val correctAnswers = arrayOf(0, 0, 0, 0, 0) // Индексы правильных ответов

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        score = intent.getIntExtra("score", 0)
        displayQuestion()

        val nextButton: Button = findViewById(R.id.nextButton)
        nextButton.setOnClickListener {
            val selectedId = findViewById<RadioGroup>(R.id.answersRadioGroup).checkedRadioButtonId
            if (selectedId != -1) {
                val selectedRadioButton = findViewById<RadioButton>(selectedId)
                val answerIndex = findViewById<RadioGroup>(R.id.answersRadioGroup).indexOfChild(selectedRadioButton)

                if (answerIndex == correctAnswers[currentQuestionIndex]) {
                    score += 100 // Добавляем 100 баллов за правильный ответ
                }

                currentQuestionIndex++

                if (currentQuestionIndex < questions.size) {
                    displayQuestion()
                } else {
                    // Переход на экран с результатами
                    val intent = Intent(this, ResultActivity::class.java)
                    intent.putExtra("score", score)
                    startActivity(intent)
                    finish()
                }
            }
        }
    }

    private fun displayQuestion() {
        val questionTextView: TextView = findViewById(R.id.questionTextView)
        val answer1: RadioButton = findViewById(R.id.answer1)
        val answer2: RadioButton = findViewById(R.id.answer2)
        val answer3: RadioButton = findViewById(R.id.answer3)

        questionTextView.text = questions[currentQuestionIndex]
        answer1.text = answers[currentQuestionIndex][0]
        answer2.text = answers[currentQuestionIndex][1]
        answer3.text = answers[currentQuestionIndex][2]

        // Сброс выбора радио-кнопок
        findViewById<RadioGroup>(R.id.answersRadioGroup).clearCheck()
    }
}