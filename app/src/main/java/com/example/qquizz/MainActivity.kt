package com.example.qquizz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn_start.setOnClickListener {
            if(et_name.text.toString().isEmpty() )
            {
                Toast.makeText(this,"Please enter your name!", Toast.LENGTH_SHORT).show()
            }
            else
            {
                Intent(this,QuestionActivity::class.java).also{
                    it.putExtra(Constants.USER_NAME,et_name.text.toString())
                    startActivity(it)
                    finish()
                }
            }
        }
    }
}