package com.example.stackoverflowdemo.data.network.converter

import com.example.stackoverflowdemo.data.common.Converter
import com.example.stackoverflowdemo.data.network.dto.tag.TagResponse
import com.example.stackoverflowdemo.data.tag.TagEntity
import javax.inject.Inject

class TagConverter @Inject constructor() : Converter<TagResponse, List<TagEntity>> {
    override fun convert(from: TagResponse): List<TagEntity> {
        val result = ArrayList<TagEntity>()
        from.items.forEach {
            with(it) {
                result.add(
                    TagEntity(
                        name,
                        count
                    )
                )
            }
        }
        return result
    }

}