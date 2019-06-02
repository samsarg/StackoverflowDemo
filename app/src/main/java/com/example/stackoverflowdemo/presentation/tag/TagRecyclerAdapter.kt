package com.example.stackoverflowdemo.presentation.tag

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflowdemo.R
import com.example.stackoverflowdemo.data.tag.TagEntity
import com.example.stackoverflowdemo.databinding.TagItemBinding

class TagRecyclerAdapter(private val tagClickListener: TagClickListener) : RecyclerView.Adapter<TagViewHolder>() {
    private var items = emptyList<TagEntity>()
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TagViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding: TagItemBinding =
            DataBindingUtil.inflate(layoutInflater, R.layout.tag_item, parent, false)
        return TagViewHolder(binding, tagClickListener)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TagViewHolder, position: Int) {
        holder.bind(items[position])
    }

    fun setItems(items: List<TagEntity>) {
        this.items = items
        notifyDataSetChanged()
    }
}

class TagViewHolder(private val tagItemBinding: TagItemBinding, private val tagClickListener: TagClickListener) :
    RecyclerView.ViewHolder(tagItemBinding.root) {
    fun bind(tagEntity: TagEntity) {
        tagItemBinding.tag = tagEntity
        tagItemBinding.listener = tagClickListener
        tagItemBinding.executePendingBindings()
    }
}