package com.example.stackoverflowdemo.presentation.question

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.data.question.QuestionRepository
import com.example.stackoverflowdemo.presentation.common.SingleLiveEvent
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class QuestionViewModel @Inject constructor(
    private val questionRepository: QuestionRepository
) : ViewModel() {
    val questions = MutableLiveData<List<QuestionEntity>>()
    val errorMessage = SingleLiveEvent<String>()
    var isLoading = MutableLiveData<Boolean>()

    private lateinit var tag: String
    var lastLoadedPageIndex = 0

    init {
        isLoading.value = false
    }

    private var disposables: Disposable? = null


    fun setTag(tag: String) {
        this.tag = tag
    }

    fun getInitialQuestions(forceRefresh: Boolean) {
        if (!forceRefresh && (isLoading.value!! || questions.value != null)) {
            return
        }
        disposables?.dispose()
        disposables = getQuestions(1)
            .subscribe({
                lastLoadedPageIndex = 1
            }, {
                errorMessage.value = "Error Occurred"
            })

    }


    fun getQuestionsForNextPage() {
        if (isLoading.value!!) {
            return
        }
        disposables = getQuestions(lastLoadedPageIndex + 1)
            .subscribe(
                {
                    lastLoadedPageIndex++
                    questions.value = it
                },
                {
                    errorMessage.value = "Error Occurred"
                }
            )

    }

    private fun getQuestions(pageIndex: Int) =
        questionRepository
            .getQuestionsByTag(tag, pageIndex)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .doOnSubscribe {
                isLoading.value = true
            }
            .doFinally {
                isLoading.value = false
            }

    override fun onCleared() {
        disposables?.dispose()
        disposables = null
    }
}
