package com.example.stackoverflowdemo.data.question

import javax.inject.Inject

const val PAGE_SIZE = 10

class QuestionRepository @Inject constructor(
    private val questionRemoteDataSource: QuestionRemoteDataSource
) {
    fun getQuestionsByTag(tag: String, pageIndex: Int) =
        questionRemoteDataSource.getQuestionsByTag(tag, pageIndex, PAGE_SIZE)
}