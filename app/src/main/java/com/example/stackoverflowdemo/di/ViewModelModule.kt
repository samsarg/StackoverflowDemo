package com.example.stackoverflowdemo.di

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflowdemo.presentation.common.ViewModelFactoryImpl
import com.example.stackoverflowdemo.presentation.question.QuestionViewModel
import com.example.stackoverflowdemo.presentation.tag.TagViewModel
import dagger.Binds
import dagger.Module
import dagger.multibindings.IntoMap

@Module
abstract class ViewModelModule {

    @Binds
    abstract fun bindViewModelFactory(impl: ViewModelFactoryImpl): ViewModelProvider.Factory

    @Binds
    @IntoMap
    @ViewModelKey(TagViewModel::class)
    abstract fun bindTagViewModel(impl: TagViewModel): ViewModel

    @Binds
    @IntoMap
    @ViewModelKey(QuestionViewModel::class)
    abstract fun bindQuestionViewModel(impl: QuestionViewModel): ViewModel
}