package com.example.stackoverflowdemo.data.tag

import javax.inject.Inject

class TagRepository @Inject constructor(
    private val remoteDataSource: TagRemoteDataSource
) {

    fun getPopularTags() = remoteDataSource.getPopularTags()
}