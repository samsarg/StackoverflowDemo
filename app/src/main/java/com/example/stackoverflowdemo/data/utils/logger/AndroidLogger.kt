package com.example.stackoverflowdemo.data.utils.logger

import android.util.Log

class AndroidLogger : Logger {
    override fun d(tag: String, msg: String) {
        Log.d(tag, msg)
    }
}