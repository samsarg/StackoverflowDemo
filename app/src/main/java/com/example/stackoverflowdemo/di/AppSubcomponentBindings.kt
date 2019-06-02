package com.example.stackoverflowdemo.di

import com.example.stackoverflowdemo.presentation.MainActivity
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class AppSubcomponentBindings {

    @ContributesAndroidInjector(modules = [MainActivitySubcomponentBindings::class])
    @ActivityScope
    internal abstract fun mainActivity(): MainActivity
}