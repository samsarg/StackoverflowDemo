package com.example.stackoverflowdemo.data.tag

import com.example.stackoverflowdemo.data.network.StackOverflowApi
import com.example.stackoverflowdemo.data.network.converter.TagConverter
import javax.inject.Inject

class TagRemoteDataSource @Inject constructor(
    private val stackOverflowApi: StackOverflowApi,
    private val tagConverter: TagConverter
) {
    fun getPopularTags() = stackOverflowApi
        .getTags()
        .map { tagConverter.convert(it) }
}