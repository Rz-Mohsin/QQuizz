package com.example.qquizz

data class Questions (
    val id: Int,
    val question : String,
    val image : Int,
    val optionone : String,
    val optiontwo : String,
    val optionthree : String,
    val optionfour : String,
    val correctAnswer : Int
)
