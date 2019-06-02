package com.example.stackoverflowdemo.presentation.question

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowdemo.R
import com.example.stackoverflowdemo.data.question.QuestionEntity
import com.example.stackoverflowdemo.databinding.QuestionItemBinding

class QuestionRecyclerAdapter() : RecyclerView.Adapter<QuestionViewHolder>() {
    private var items = emptyList<QuestionEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): QuestionViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: QuestionItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.question_item, parent, false)
        return QuestionViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: QuestionViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<QuestionEntity>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class QuestionViewHolder(
    private val questionItemBinding: QuestionItemBinding
) :
    RecyclerView.ViewHolder(questionItemBinding.root) {
    fun bind(questionEntity: QuestionEntity) {
        questionItemBinding.question = questionEntity
        questionItemBinding.executePendingBindings()
    }
}