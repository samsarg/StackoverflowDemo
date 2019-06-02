package com.example.stackoverflowdemo.data.network.dto.question

//TODO specify nullable fields
data class Owner(
    val display_name: String,
    val link: String,
    val profile_image: String,
    val reputation: Int,
    val user_id: Int,
    val user_type: String
)