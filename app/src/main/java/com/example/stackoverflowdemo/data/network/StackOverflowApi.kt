package com.example.stackoverflowdemo.data.network

import com.example.stackoverflowdemo.data.network.dto.question.QuestionResponse
import com.example.stackoverflowdemo.data.network.dto.tag.TagResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface StackOverflowApi {

    //TODO do not hardcode params let data source layer decide params
    @GET("/2.2/tags?page=1&pagesize=30&order=desc&sort=popular&site=stackoverflow")
    fun getTags(): Single<TagResponse>

    //TODO do not hardcode params let data source layer decide params
    @GET("/2.2/questions?order=asc&sort=activity&site=stackoverflow")
    fun getQuestions(
        @Query("tagged") tag: String,
        @Query("page") pageIndex: Int,
        @Query("pagesize") pageSize: Int
    ): Single<QuestionResponse>
}