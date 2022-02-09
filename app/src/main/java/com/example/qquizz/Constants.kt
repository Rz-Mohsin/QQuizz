package com.example.qquizz

object Constants {

    const val USER_NAME : String = "user_name"
    const val TOTAL_QUESTIONS : String = "total_questions"
    const val CORRECT_ANSWERS : String = "correct_answers"

    fun getQuestions() : ArrayList<Questions>{
        val questionsList = ArrayList<Questions>()

        val que1 = Questions(1,"what country does this flag belongs to?",
        R.drawable.ic_flag_of_argentina,
            "Argentina",
            "Australia",
            "Germany",
            "Austria",
            1
        )

        val que2 = Questions(2,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_australia,
            "Argentina",
            "Australia",
            "Germany",
            "Austria",
            2
        )

        val que3 = Questions(3,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_brazil,
            "Brazil",
            "Italy",
            "Germany",
            "Austria",
            1
        )

        val que4 = Questions(4,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_fiji,
            "Argentina",
            "Australia",
            "fiji",
            "Austria",
            3
        )

        val que5 = Questions(5,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_denmark,
            "Argentina",
            "Australia",
            "Germany",
            "Denmark",
            4
        )

        val que6 = Questions(6,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_india,
            "Kuwait",
            "Australia",
            "India",
            "Austria",
            3
        )

        val que7 = Questions(7,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_belgium,
            "China",
            "Belgium",
            "Germany",
            "Austria",
            2
        )

        val que8 = Questions(8,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_new_zealand,
            "New Zealand",
            "Australia",
            "Germany",
            "England",
            1
        )

        val que9 = Questions(9,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_kuwait,
            "West Indies",
            "Australia",
            "Kuwait",
            "Austria",
            3
        )

        val que10 = Questions(10,"what country does this flag belongs to?",
            R.drawable.ic_flag_of_germany,
            "Iran",
            "Australia",
            "Germany",
            "Austria",
            3
        )


        questionsList.add(que1)
        questionsList.add(que2)
        questionsList.add(que3)
        questionsList.add(que4)
        questionsList.add(que5)
        questionsList.add(que6)
        questionsList.add(que7)
        questionsList.add(que8)
        questionsList.add(que9)
        questionsList.add(que10)
        return questionsList
    }
}