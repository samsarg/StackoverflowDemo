package com.example.stackoverflowdemo.data.question

data class QuestionEntity(
    val id: Long,
    val title: String,
    val isAnswered: Boolean,
    val score: Int,
    val updateDate: Long,
    val tags: List<String>
)