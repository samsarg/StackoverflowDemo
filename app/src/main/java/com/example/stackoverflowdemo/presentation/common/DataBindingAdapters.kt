package com.example.stackoverflowdemo.presentation.common

import androidx.databinding.BindingAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.data.tag.TagEntity
import com.example.stackoverflowdemo.presentation.tag.TagRecyclerAdapter

//@BindingAdapter("refreshing")
//fun SwipeRefreshLayout.refreshing(isRefreshing: Boolean?) {
//    if (isRefreshing != null) {
//        this.isRefreshing = isRefreshing
//    } else {
//        this.isRefreshing = false
//    }
//}

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

}
//fun SwipeRefreshLayout.refreshing(isRefreshing: Boolean?) {
//    if (isRefreshing != null) {
//        this.isRefreshing = isRefreshing
//    } else {
//        this.isRefreshing = false
//    }
//}

