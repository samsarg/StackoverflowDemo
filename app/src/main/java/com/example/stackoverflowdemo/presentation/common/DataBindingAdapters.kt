package com.example.stackoverflowdemo.presentation.common

import android.widget.TextView
import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.data.tag.TagEntity
import com.example.stackoverflowdemo.presentation.question.QuestionRecyclerAdapter
import com.example.stackoverflowdemo.presentation.tag.TagRecyclerAdapter

@BindingAdapter("items")
fun RecyclerView.tagItems(list: List<TagEntity>?) {
    list?.let {
        if (this.adapter is TagRecyclerAdapter) {
            (this.adapter as TagRecyclerAdapter).setItems(it)
        }
    }
}

@BindingAdapter("items")
fun RecyclerView.questionItems(list: List<QuestionEntity>?) {

    list?.let {
        if (this.adapter is QuestionRecyclerAdapter) {
            (this.adapter as QuestionRecyclerAdapter).setItems(it)
        }
    }
}

@BindingAdapter("android:text")
fun TextView.extInt(text: Int) {
    this.text = Integer.toString(text)
}