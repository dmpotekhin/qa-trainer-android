package com.example.qatrainer.ui.gestures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qatrainer.databinding.PageGestureBinding

class GesturePageAdapter(
    private val pages: List<Pair<String, String>>
) : RecyclerView.Adapter<GesturePageAdapter.PageViewHolder>() {

    class PageViewHolder(val binding: PageGestureBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): PageViewHolder {
        val binding = PageGestureBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return PageViewHolder(binding)
    }

    override fun onBindViewHolder(holder: PageViewHolder, position: Int) {
        val (title, desc) = pages[position]
        holder.binding.tvPageTitle.text = title
        holder.binding.tvPageDesc.text = desc
        holder.binding.root.contentDescription = "Page ${position + 1}: $title"
        holder.binding.root.tag = "gesture_page_${position + 1}"
    }

    override fun getItemCount() = pages.size
}
