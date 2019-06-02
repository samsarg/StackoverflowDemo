package com.example.stackoverflowdemo.data.question

import com.example.stackoverflowdemo.data.network.StackOverflowApi
import com.example.stackoverflowdemo.data.network.converter.QuestionConverter
import javax.inject.Inject

class QuestionRemoteDataSource @Inject constructor(
    private val stackOverflowApi: StackOverflowApi,
    private val questionConverter: QuestionConverter
) {
    fun getQuestionsByTag(tag: String, pageIndex: Int, pageSize: Int) =
        stackOverflowApi
            .getQuestions(tag, pageIndex, pageSize)
            .map { questionConverter.convert(it) }

}