package com.example.stackoverflowdemo.data.network.dto.question

//TODO specify nullable fields
data class QuestionResponse(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)