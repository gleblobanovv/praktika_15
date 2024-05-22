package com.example.praktika_15_lobanov

import android.app.Application
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast


private var questIndex=0

class SplashScreen : AppCompatActivity() {
    private lateinit var trueButton: Button
    private lateinit var falseButton: Button
    private lateinit var textView: TextView

    data class Quest(
        val questText: String,
        val answer: Boolean
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        trueButton = findViewById(R.id.true_button)
        falseButton = findViewById(R.id.false_button)
        textView = findViewById(R.id.quest)
        trueButton.setOnClickListener { checkAnswer(true) }
        falseButton.setOnClickListener { checkAnswer(false) }
        initialQuestAndAnswer()
        setQuest()
    }

    private lateinit var questAndAnswer: List<Quest>
    private fun initialQuestAndAnswer() {
        questAndAnswer = listOf(
            Quest(getString(R.string.quest1), true),
            Quest(getString(R.string.quest2), true),
            Quest(getString(R.string.quest3), true),
            Quest(getString(R.string.quest4), true),
            Quest(getString(R.string.quest5), true),
            Quest(getString(R.string.quest6), true),
            Quest(getString(R.string.quest7), true),
            Quest(getString(R.string.quest8), true),
            Quest(getString(R.string.quest9), true),
            Quest(getString(R.string.quest10), true)
        )
    }

    private fun setQuest() {
        val currentQuest = questAndAnswer[questIndex]
        textView.text = currentQuest.questText
    }

    private fun checkAnswer(userAnswer: Boolean) {
        val currentQuest = questAndAnswer[questIndex]
        if (userAnswer == currentQuest.answer) {
            Toast.makeText(this, getString(R.string.correct_toast), Toast.LENGTH_SHORT).show()
        } else {
            Toast.makeText(this, getString(R.string.incorrect_toast), Toast.LENGTH_SHORT).show()
        }
        questIndex++
        if (questIndex < questAndAnswer.size) {
            setQuest()
        }else{
            application.onTerminate()
        }
    }
}
