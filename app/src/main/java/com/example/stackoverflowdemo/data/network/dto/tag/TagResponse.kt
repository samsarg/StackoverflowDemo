package com.example.stackoverflowdemo.data.network.dto.tag

//TODO specify nullable fields
data class TagResponse(
    val has_more: Boolean,
    val items: List<Item>,
    val quota_max: Int,
    val quota_remaining: Int
)