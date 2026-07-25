package com.example.qatrainer.ui.gestures

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.qatrainer.databinding.ItemDragBinding

class DragAdapter(
    private val onDragHandleLongPress: (DragAdapter.ViewHolder) -> Unit
) : RecyclerView.Adapter<DragAdapter.ViewHolder>() {

    private val items = mutableListOf(
        "Item A - Drag me first",
        "Item B - Move this up",
        "Item C - Swap with D",
        "Item D - Reorder freely",
        "Item E - Last item"
    )

    class ViewHolder(val binding: ItemDragBinding) : RecyclerView.ViewHolder(binding.root) {
        init {
            binding.ivDragHandle.tag = "drag_handle"
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemDragBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.binding.tvDragText.text = items[position]
        holder.binding.root.contentDescription = "Draggable item ${position + 1}: ${items[position]}"

        holder.binding.ivDragHandle.setOnLongClickListener {
            onDragHandleLongPress(holder)
            true
        }
    }

    override fun getItemCount() = items.size

    fun moveItem(from: Int, to: Int) {
        val moved = items.removeAt(from)
        items.add(to, moved)
        notifyItemMoved(from, to)
    }

    fun getItems() = items.toList()
}
