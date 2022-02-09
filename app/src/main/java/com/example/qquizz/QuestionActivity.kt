package com.example.qquizz

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_question.*

class QuestionActivity : AppCompatActivity(), View.OnClickListener {

    private var mCurrentPosition: Int = 1
    private var mQuestionsList : ArrayList<Questions>? = null
    private var mSelectedOptionPosition : Int = 0
    private var mCorrectAnswer : Int = 0
    private var mUserName : String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_question)

        mUserName = intent.getStringExtra(Constants.USER_NAME)

        mQuestionsList = Constants.getQuestions()

        setQuestion()

        tv_option_one.setOnClickListener(this)
        tv_option_two.setOnClickListener(this)
        tv_option_three.setOnClickListener(this)
        tv_option_four.setOnClickListener(this)
        btn_submit.setOnClickListener(this)

    }

    private fun setQuestion(){
        val question = mQuestionsList?.get(mCurrentPosition-1)

        defaultOptionsView()
        btn_submit.text = "SUBMIT"
        if(mCurrentPosition >= mQuestionsList!!.size) {
            btn_submit.text = "FINISH"
        }
        progress_bar.progress = mCurrentPosition
        tv_progress.text = "$mCurrentPosition" + "/" + progress_bar.max

        tv_question.text = question!!.question
        iv_image.setImageResource(question.image)
        tv_option_one.text = question.optionone
        tv_option_two.text = question.optiontwo
        tv_option_three.text = question.optionthree
        tv_option_four.text = question.optionfour
    }

    private fun defaultOptionsView(){
        val options = ArrayList<TextView>()
        options.add(0,tv_option_one)
        options.add(1,tv_option_two)
        options.add(2,tv_option_three)
        options.add(3,tv_option_four)

        for(option in options){
            option.setTextColor(Color.parseColor("#7A8089"))
            option.typeface = Typeface.DEFAULT
            option.background = ContextCompat.getDrawable(this,
                R.drawable.default_option_border_bg
            )
        }
    }

    override fun onClick(p0: View?) {
        when(p0?.id){
            R.id.tv_option_one -> {
                selectedOptionView(tv_option_one,1)
            }
            R.id.tv_option_two -> {
                selectedOptionView(tv_option_two,2)
            }
            R.id.tv_option_three -> {
                selectedOptionView(tv_option_three,3)
            }
            R.id.tv_option_four -> {
                selectedOptionView(tv_option_four,4)
            }
            R.id.btn_submit ->{
                if(mSelectedOptionPosition == 0)
                {
                    mCurrentPosition++

                    when{
                        mCurrentPosition <= mQuestionsList!!.size ->{
                            setQuestion()
                        }else ->{
                            Intent(this,ResultActivity::class.java).also {
                                it.putExtra(Constants.USER_NAME,mUserName)
                                it.putExtra(Constants.CORRECT_ANSWERS,mCorrectAnswer)
                                it.putExtra(Constants.TOTAL_QUESTIONS,mQuestionsList!!.size)
                                startActivity(it)
                                finish()
                            }
                        }
                    }
                }
                else
                {
                    val question = mQuestionsList?.get(mCurrentPosition-1)
                    if(question!!.correctAnswer != mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else
                    {
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(mCurrentPosition == mQuestionsList!!.size)
                    {
                        btn_submit.text = "FINISH"
                    }else
                    {
                        btn_submit.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }


            }
        }
    }

    private fun answerView(answer : Int, drawableView : Int)
    {
        when(answer)
        {
            1-> {
                tv_option_one.background = ContextCompat.getDrawable(this,
                drawableView)
            }
            2-> {
                tv_option_two.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            3-> {
                tv_option_three.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
            4-> {
                tv_option_four.background = ContextCompat.getDrawable(this,
                    drawableView)
            }
        }
    }

    private fun selectedOptionView(tv : TextView, selectedOptionNumber : Int){
        defaultOptionsView()
        mSelectedOptionPosition = selectedOptionNumber

        tv.setTextColor(Color.parseColor("#363A43"))
        tv.setTypeface(tv.typeface, Typeface.BOLD)
        tv.background = ContextCompat.getDrawable(this,
            R.drawable.select_option_border_bg
        )
    }
}