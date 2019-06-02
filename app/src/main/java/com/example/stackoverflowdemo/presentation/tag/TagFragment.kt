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

class TagFragment : BaseFragment() {

    companion object {
        fun newInstance() = TagFragment()
    }

    lateinit var viewModel: TagViewModel

    lateinit var adapter: TagRecyclerAdapter

    lateinit var binding: TagFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = TagFragmentBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(TagViewModel::class.java)
        adapter = TagRecyclerAdapter(viewModel)
        binding.recyclerView.adapter = adapter
        binding.setLifecycleOwner(this.viewLifecycleOwner)
        binding.viewmodel = viewModel
        viewModel.getTags()
    }


    override fun onStart() {
        super.onStart()
        viewModel.tagNavigation.observe(this, Observer {
            fragmentManager?.beginTransaction()
                ?.replace(R.id.fragmentContainer, QuestionFragment.newInstance(it))
                ?.addToBackStack(null)
                ?.commit()
        })
    }

}
