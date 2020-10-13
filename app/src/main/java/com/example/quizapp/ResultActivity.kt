package com.example.quizapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)
        val sharedPreference =  getSharedPreferences(Constant.PREF_QUIZ, Context.MODE_PRIVATE)
        val userName=sharedPreference.getString(Constant.USER_NAME,"")
        val totalQuestions=intent.getIntExtra(Constant.TOTAL_QUESTION,0)
        val correctAnswers=intent.getIntExtra(Constant.CORRECT_ANSWER,0)
        tv_name.text=userName
        tv_score.text="Your Score is $correctAnswers out of $totalQuestions"
        btn_finish.setOnClickListener {
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
}