package com.example.stackoverflowdemo.presentation.tag

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.example.stackoverflowdemo.R
import com.example.stackoverflowdemo.databinding.TagFragmentBinding
import com.example.stackoverflowdemo.presentation.common.BaseFragment
import com.example.stackoverflowdemo.presentation.question.QuestionFragment
import javax.inject.Inject

class TagFragment : BaseFragment() {

    companion object {
        fun newInstance() = TagFragment()
    }

    @Inject
    lateinit var viewModel: TagViewModel

    lateinit var adapter: TagRecyclerAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = TagFragmentBinding.inflate(inflater, container, false)
        adapter = TagRecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.lifecycleOwner = this
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TagViewModel::class.java)
        viewModel.getTags()
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.tagNavigation.observe(this, Observer {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, QuestionFragment.newInstance(it))
                ?.addToBackStack(null)
                ?.commit()
        })
        viewModel.tags.observe(this, Observer {
            adapter.setItems(it)
        })
    }

}
