package com.example.stackoverflowdemo.presentation.common

import android.content.Context
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import dagger.android.support.AndroidSupportInjection

abstract class BaseFragment : Fragment() {

    protected lateinit var viewModelFactory: ViewModelProvider.Factory

    override fun onAttach(context: Context?) {
        super.onAttach(context)
        performDependencyInjection()
    }

    private fun performDependencyInjection() {
        AndroidSupportInjection.inject(this)
    }
}