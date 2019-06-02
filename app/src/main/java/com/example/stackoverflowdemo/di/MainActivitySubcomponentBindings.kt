package com.example.stackoverflowdemo.di

import com.example.stackoverflowdemo.presentation.question.QuestionFragment
import com.example.stackoverflowdemo.presentation.tag.TagFragment
import dagger.Module
import dagger.android.ContributesAndroidInjector

@Module
abstract class MainActivitySubcomponentBindings {

    @ContributesAndroidInjector()
    @FragmentScope
    internal abstract fun tagsFragment(): TagFragment

    @ContributesAndroidInjector()
    @FragmentScope
    internal abstract fun questionsFragment(): QuestionFragment

}