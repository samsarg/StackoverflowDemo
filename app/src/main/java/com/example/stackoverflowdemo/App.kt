package com.example.stackoverflowdemo

import android.app.Application
import com.example.stackoverflowdemo.data.question.QuestionRepository
import com.example.stackoverflowdemo.data.tag.TagRepository
import com.example.stackoverflowdemo.di.DaggerAppComponent
import javax.inject.Inject

class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .create(this)
            .inject(this)
    }
}