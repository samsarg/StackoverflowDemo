package com.example.stackoverflowdemo.presentation

import android.app.Activity
import android.app.Application
import com.example.stackoverflowdemo.di.DaggerAppComponent
import dagger.android.AndroidInjector
import dagger.android.DispatchingAndroidInjector
import dagger.android.HasActivityInjector
import javax.inject.Inject

class App : Application(), HasActivityInjector {
    @Inject
    lateinit var dispatchingActivityInjector: DispatchingAndroidInjector<Activity>

    override fun activityInjector(): AndroidInjector<Activity> =
        dispatchingActivityInjector

    override fun onCreate() {
        super.onCreate()
        DaggerAppComponent
            .builder()
            .create(this)
            .inject(this)
    }
}