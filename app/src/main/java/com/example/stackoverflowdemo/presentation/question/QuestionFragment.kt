package com.example.stackoverflowdemo.presentation.question

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowdemo.databinding.QuestionFragmentBinding
import com.example.stackoverflowdemo.presentation.common.BaseFragment
import com.example.stackoverflowdemo.presentation.utls.recycler.ScrollEndDetector
import com.example.stackoverflowdemo.presentation.utls.recycler.ScrollEndListener

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

    private val adapter = QuestionRecyclerAdapter()

    private lateinit var binding: QuestionFragmentBinding

    private val scrollEndListener = object : ScrollEndListener {
        override fun reachedEnd() {
            viewModel.getQuestionsForNextPage()
        }

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = QuestionFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    private fun getTagArgument(): String {
        return arguments!!.getString(TAG_ARG_KEY)!!
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        binding.recyclerView.adapter = adapter
        binding.recyclerView.addOnScrollListener(ScrollEndDetector(scrollEndListener))
        binding.lifecycleOwner = this
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(QuestionViewModel::class.java)
        binding.viewmodel = viewModel
        viewModel.setTag(getTagArgument())
        viewModel.getInitialQuestions(false)
    }


}
