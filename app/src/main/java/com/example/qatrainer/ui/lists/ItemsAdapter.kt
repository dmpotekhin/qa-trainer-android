package com.example.qatrainer.ui.lists

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.view.ViewCompat
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.qatrainer.R
import com.example.qatrainer.databinding.ItemListBinding

class ItemsAdapter(
    private val onItemClick: (ListItem, ItemListBinding) -> Unit,
    private val onFavoriteToggle: (ListItem) -> Unit
) : ListAdapter<ListItem, ItemsAdapter.ViewHolder>(DiffCallback) {

    class ViewHolder(val binding: ItemListBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemListBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        with(holder.binding) {
            tvItemTitle.text = item.title
            tvItemDesc.text = item.description

            // Set favorite icon state
            btnFavorite.setImageResource(
                if (item.isFavorite) R.drawable.ic_favorite_filled
                else R.drawable.ic_favorite_border
            )

            // Content descriptions for testability
            root.contentDescription = "List item ${item.id}: ${item.title}"
            root.tag = "list_item_${item.id}"

            // Transition name for shared element transition
            ViewCompat.setTransitionName(ivItemIcon, "item_image_${item.id}")

            btnFavorite.setOnClickListener { onFavoriteToggle(item) }
            root.setOnClickListener { onItemClick(item, this) }
        }
    }

    object DiffCallback : DiffUtil.ItemCallback<ListItem>() {
        override fun areItemsTheSame(oldItem: ListItem, newItem: ListItem) = oldItem.id == newItem.id
        override fun areContentsTheSame(oldItem: ListItem, newItem: ListItem) = oldItem == newItem
    }
}
