package com.example.stackoverflowdemo.presentation.tag

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.stackoverflowdemo.data.tag.TagEntity
import com.example.stackoverflowdemo.data.tag.TagRepository
import com.example.stackoverflowdemo.presentation.common.SingleLiveEvent
import com.example.stackoverflowdemo.presentation.utls.EspressoIdlingResource
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.Disposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class TagViewModel @Inject constructor(
    private val tagRepository: TagRepository
) : ViewModel(), TagClickListener {

    val tags = MutableLiveData<List<TagEntity>>().apply { emptyList<TagEntity>() }
    val isLoading = MutableLiveData<Boolean>()
    val errorMessage = SingleLiveEvent<String>()
    //TODO create common class vor navigation entity
    val tagNavigation = SingleLiveEvent<String>()
    private var disposables: Disposable? = null

    init {
        isLoading.value = false
    }

    fun getTags() {
        if (isLoading.value!!) {
            return
        }
        disposables?.dispose()
        disposables =
            tagRepository
                .getPopularTags()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .doOnSubscribe {
                    isLoading.value = true
                    EspressoIdlingResource.increment()
                }
                .doFinally {
                    isLoading.value = false
                    EspressoIdlingResource.decrement()
                }
                .subscribe(
                    {
                        tags.value = it
                    },
                    {
                        errorMessage.value = it.toString()
                    }
                )
    }

    fun onRefresh() {
        getTags()
    }

    override fun onTagClicked(tag: TagEntity) {
        tagNavigation.value = tag.name
    }

    override fun onCleared() {
        disposables?.dispose()
        disposables = null
    }
}
