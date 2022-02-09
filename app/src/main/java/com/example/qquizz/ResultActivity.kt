package com.example.qquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_result.*

class ResultActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        val username = intent.getStringExtra(Constants.USER_NAME)
        val correctAnswer = intent.getIntExtra(Constants.CORRECT_ANSWERS,0)
        val totalAnswer = intent.getIntExtra(Constants.TOTAL_QUESTIONS,0)
        tv_username.text = username
        tv_score.text = "You have scored $correctAnswer out of $totalAnswer"

        btn_finish.setOnClickListener{
            Intent(this,MainActivity::class.java).also {
                startActivity(it)
                finish()
            }
        }

    }
}