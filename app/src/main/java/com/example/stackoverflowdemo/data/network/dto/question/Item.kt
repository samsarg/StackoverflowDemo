package com.example.stackoverflowdemo.data.network.dto.question

//TODO specify nullable fields
data class Item(
    val accepted_answer_id: Int,
    val answer_count: Int,
    val creation_date: Int,
    val is_answered: Boolean,
    val last_activity_date: Long,
    val last_edit_date: Long,
    val link: String,
    val owner: Owner,
    val question_id: Long,
    val score: Int,
    val tags: List<String>,
    val title: String,
    val view_count: Int
)