package com.example.stackoverflowdemo.presentation.common

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.stackoverflowdemo.di.AppScope
import javax.inject.Inject
import javax.inject.Provider

@AppScope
class ViewModelFactoryImpl
@Inject constructor(
    private val factories: MutableMap<Class<out ViewModel>, @JvmSuppressWildcards Provider<ViewModel>>
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T =
        requireNotNull(factories[modelClass]).get() as T

}