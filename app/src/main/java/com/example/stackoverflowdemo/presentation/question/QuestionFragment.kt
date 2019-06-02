package com.example.stackoverflowdemo.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowdemo.R
import com.example.stackoverflowdemo.presentation.common.BaseFragment

const val TAG_ARG_KEY = "TAG_ARG_KEY"

class QuestionFragment : BaseFragment() {

    companion object {
        fun newInstance(tag: String) =
            QuestionFragment().apply {
                val bundle = Bundle(1)
                bundle.putString(TAG_ARG_KEY, tag)
                arguments = bundle
            }

    }

    private lateinit var viewModel: QuestionViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.question_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.getInitialQuestions(false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
        // TODO: Use the ViewModel
    }


}
