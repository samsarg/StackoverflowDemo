package com.example.stackoverflowdemo.presentation.utls.recycler

import androidx.recyclerview.widget.RecyclerView

class LazyScrollEndDetector(private val callback: ScrollEndListener) : RecyclerView.OnScrollListener() {

    override fun onScrollStateChanged(recyclerView: RecyclerView, newState: Int) {
        super.onScrollStateChanged(recyclerView, newState)
        if (!recyclerView.canScrollVertically(1) && newState == RecyclerView.SCROLL_STATE_IDLE) {
            callback.reachedEnd()
        }
    }

}