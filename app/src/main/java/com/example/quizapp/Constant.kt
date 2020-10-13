package com.example.quizapp

object Constant {
    const val PREF_QUIZ:String="pref_qui"
    const val CHECK:String="check"
    const val USER_NAME:String="user_name"
    const val TOTAL_QUESTION:String="total_question"
    const val CORRECT_ANSWER:String="correct_answer"
    fun getQuestions():ArrayList<Question>{
        val questionList=ArrayList<Question>()
        val que1=Question(
            1,"What scientist name?"
            ,R.drawable.charles_babge,
            "Charles Babbage",
            "Mark Zuckerberg",
            "Bill Gates",
            "Kevin Systrom",
            1
        )
        questionList.add(que1)
        val que2=Question(
            2,"What scientist name?"
            ,R.drawable.steve_jobs,
            "Mark Zuckerberg",
            "Bill Gates",
            "Steve Jobs",
            "Kevin Systrom",
            3
        )
        questionList.add(que2)
        val que3=Question(
            3,"What scientist name?"
            ,R.drawable.mark_zuckerberg,
            "Kevin Systrom",
            "Mark Zuckerberg",
            "Bill Gates",
            "Jan Koum",
            2
        )
        questionList.add(que3)
        val que4=Question(
            4,"What scientist name?"
            ,R.drawable.bill_gates,
            "Jan Koum",
            "Steve Jobs",
            "Mark Zuckerberg",
            "Bill Gates",
            4
        )
        questionList.add(que4)
        val que5=Question(
            5,"What scientist name?"
            ,R.drawable.jan_koum,
            "Bill Gates",
            "Jan Koum",
            "Mark Zuckerberg",
            "Steve Jobs",
            2
        )
        questionList.add(que5)
        val que6=Question(
            6,"What scientist name?"
            ,R.drawable.kevin_systrom,
            "Steve Jobs",
            "Jan Koum",
            "Kevin Systrom",
            "Bill Gates",
            3
        )
        questionList.add(que6)

        return questionList
    }
}