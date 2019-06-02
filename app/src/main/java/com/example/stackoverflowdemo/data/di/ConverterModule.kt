package com.example.stackoverflowdemo.data.di

import com.example.stackoverflowdemo.data.common.Converter
import com.example.stackoverflowdemo.data.network.converter.QuestionConverter
import com.example.stackoverflowdemo.data.network.converter.TagConverter
import com.example.stackoverflowdemo.data.network.dto.question.QuestionResponse
import com.example.stackoverflowdemo.data.network.dto.tag.TagResponse
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.data.tag.TagEntity
import dagger.Binds
import dagger.Module

@Module
abstract class ConverterModule {

    //FIXME compile issue  error: @Binds methods' parameter type must be assignable to the return type
//    @Binds
//    abstract fun bindQuestionConverter(questionConverter: QuestionConverter): Converter<QuestionResponse, List<QuestionEntity>>
//
//    @Binds
//    abstract fun bindTagConverter(tagConverter: TagConverter): Converter<TagResponse, List<TagEntity>>

}