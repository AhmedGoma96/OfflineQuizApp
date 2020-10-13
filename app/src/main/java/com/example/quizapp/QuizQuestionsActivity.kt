package com.example.quizapp

import android.annotation.SuppressLint
import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import kotlinx.android.synthetic.main.activity_quiz_questions.*
import java.util.*
import kotlin.collections.ArrayList

class QuizQuestionsActivity : AppCompatActivity(),View.OnClickListener {
    private var myCurrentPosition:Int=1
    private var myQuestionList:ArrayList<Question>?=null
    private var mSelectedOptionPosition:Int=0
    private var mCorrectAnswer:Int=0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz_questions)
       myQuestionList=Constant.getQuestions()
        myQuestionList!!.shuffle()
       setQuestion()
        optionOneTv.setOnClickListener(this)
        optionSecondTv.setOnClickListener(this)
        optionThreeTv.setOnClickListener(this)
        optionFourTv.setOnClickListener(this)
         submitBtn.setOnClickListener(this)

    }
    private fun setQuestion(){

        val question= myQuestionList!![myCurrentPosition-1]
        defaultOptionView()
        if(myCurrentPosition==myQuestionList!!.size){
            submitBtn.text=resources.getString(R.string.finish)
        }
        else{
            submitBtn.text=resources.getString(R.string.submit)
        }
        progressBar.progress=myCurrentPosition
        progressTv.text="$myCurrentPosition" + "/" +progressBar.max

        questionTv.text=question!!.question
        scientistIv.setImageResource(question.image)
        optionOneTv.text=question.optionOne
        optionSecondTv.text=question.optionTwo
        optionThreeTv.text=question.optionThree
        optionFourTv.text=question.optionFour
    }
    @SuppressLint("ResourceAsColor")
    private fun defaultOptionView(){
        var options=ArrayList<TextView>()
        options.add(0,optionOneTv)
        options.add(1,optionSecondTv)
        options.add(2,optionThreeTv)
        options.add(3,optionFourTv)
        for(option in options){
            option.setTextColor(R.color.hint_color)
            option.typeface= Typeface.DEFAULT
            option.background=ContextCompat.getDrawable(this,R.drawable.default_option_border_bg)
        }
    }

    override fun onClick(v: View?) {
        when(v?.id){
            R.id.optionOneTv->{
            selectedOptionView(optionOneTv,1)
        }
            R.id.optionSecondTv->{
                selectedOptionView(optionSecondTv,2)
            }
            R.id.optionThreeTv->{
                selectedOptionView(optionThreeTv,3)
            }
            R.id.optionFourTv->{
                selectedOptionView(optionFourTv,4)
            }
            R.id.submitBtn->{
                if(mSelectedOptionPosition==0){
                    myCurrentPosition++

                    when{
                        myCurrentPosition<=myQuestionList!!.size->{
                            setQuestion()
                        }
                        else->{
                           val intent= Intent(this,ResultActivity::class.java)
                            intent.putExtra(Constant.CORRECT_ANSWER,mCorrectAnswer)
                            intent.putExtra(Constant.TOTAL_QUESTION,myQuestionList!!.size)
                            startActivity(intent)
                            finish()
                        }
                    }
                                              }
                else{
                    val question=myQuestionList?.get(myCurrentPosition-1)
                    if(question!!.correctAnswer!=mSelectedOptionPosition){
                        answerView(mSelectedOptionPosition,R.drawable.wrong_option_border_bg)
                    }
                    else{
                        mCorrectAnswer++
                    }
                    answerView(question.correctAnswer,R.drawable.correct_option_border_bg)
                    if(myCurrentPosition==myQuestionList!!.size){
                        submitBtn.text=resources.getString(R.string.finish)
                    }else{
                        submitBtn.text=resources.getString(R.string.go_to_next_question)
                    }
                    mSelectedOptionPosition=0
                }

            }
        }

    }
    private fun answerView(answer:Int,drawableView:Int){
        when(answer){
            1->{
                optionOneTv.background=ContextCompat.getDrawable(this,drawableView)
            }
            2->{
                optionSecondTv.background=ContextCompat.getDrawable(this,drawableView)
            }
            3->{
                optionThreeTv.background=ContextCompat.getDrawable(this,drawableView)
            }
            4->{
                optionFourTv.background=ContextCompat.getDrawable(this,drawableView)
            }
        }

    }
    @SuppressLint("ResourceAsColor")
    private fun selectedOptionView(tv:TextView, selectedOptionNum:Int){
        defaultOptionView()
        mSelectedOptionPosition=selectedOptionNum
        tv.setTextColor(R.color.vulcan)
     tv.setTypeface(tv.typeface,Typeface.BOLD)
        tv.background=ContextCompat.getDrawable(this,R.drawable.selected_option_border_bg)

    }
}