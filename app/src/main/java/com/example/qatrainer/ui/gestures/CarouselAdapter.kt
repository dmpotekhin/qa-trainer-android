package com.example.qatrainer.ui.gestures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qatrainer.databinding.ItemCarouselBinding

class CarouselAdapter(
    private val items: List<String>
) : RecyclerView.Adapter<CarouselAdapter.ViewHolder>() {

    class ViewHolder(val binding: ItemCarouselBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCarouselBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvCarouselLabel.text = items[position]
        holder.binding.root.contentDescription = "Carousel item ${position + 1}: ${items[position]}"
    }

    override fun getItemCount() = items.size
}
