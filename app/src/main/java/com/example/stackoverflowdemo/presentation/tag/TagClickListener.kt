package com.example.stackoverflowdemo.presentation.tag

import com.example.stackoverflowdemo.data.tag.TagEntity

interface TagClickListener {
    fun onTagClicked(tag: TagEntity)
}