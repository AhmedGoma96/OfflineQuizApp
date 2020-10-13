package com.example.quizapp
import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        val sharedPreference =  getSharedPreferences(Constant.PREF_QUIZ,Context.MODE_PRIVATE)
        var editor = sharedPreference.edit()
        var check=sharedPreference.getBoolean(Constant.CHECK,false)

        super.onCreate(savedInstanceState)
        if(check){
            val intent =Intent(this,QuizQuestionsActivity::class.java)
            startActivity(intent)
            finish()
        }
        else{
            setContentView(R.layout.activity_main)
            btn_start.setOnClickListener {
                if(edit_text.text.toString().isEmpty()){
                    Toast.makeText(this,"please enter your name",Toast.LENGTH_SHORT).show()
                }
                else{
                    editor.putBoolean(Constant.CHECK,true)
                    editor.putString(Constant.USER_NAME,edit_text.text.toString())
                    editor.commit()
                    val intent =Intent(this,QuizQuestionsActivity::class.java)
                    // intent.putExtra(Constant.USER_NAME,edit_text.text.toString())
                    startActivity(intent)
                    finish()
                }
            }
        }



    }
}