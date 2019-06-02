package com.example.stackoverflowdemo.data.network.converter

import com.example.stackoverflowdemo.data.common.Converter
import com.example.stackoverflowdemo.data.network.dto.question.QuestionResponse
import com.example.stackoverflowdemo.data.question.QuestionEntity
import javax.inject.Inject

class QuestionConverter @Inject constructor() : Converter<QuestionResponse, List<QuestionEntity>> {
    override fun convert(from: QuestionResponse): List<QuestionEntity> {
        val result = ArrayList<QuestionEntity>()
        from.items.forEach {
            with(it) {
                result.add(
                    QuestionEntity(
                        question_id,
                        title,
                        is_answered,
                        score,
                        last_activity_date,
                        tags
                    )
                )
            }
        }
        return result
    }
}