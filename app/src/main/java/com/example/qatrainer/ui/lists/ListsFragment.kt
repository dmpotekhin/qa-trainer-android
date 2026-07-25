package com.example.qatrainer.ui.lists

import android.os.Bundle
import android.view.View
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentListsBinding

class ListsFragment : Fragment(R.layout.fragment_lists) {

    private var _binding: FragmentListsBinding? = null
    private val binding get() = _binding!!

    private val allItems = ListItem.sampleData()
    private val adapter: ItemsAdapter by lazy {
        ItemsAdapter(
            onItemClick = { item, itemBinding ->
                findNavController().navigate(
                    R.id.nav_detail,
                    bundleOf("itemId" to item.id, "itemTitle" to item.title, "itemDesc" to item.description),
                    androidx.navigation.NavOptions.Builder()
                        .addSharedElement(itemBinding.ivItemIcon, "item_image_${item.id}")
                        .build()
                )
            },
            onFavoriteToggle = { item ->
                item.isFavorite = !item.isFavorite
                applyFilter()
            }
        )
    }

    private var currentFilter: String = "All"
    private var searchQuery: String = ""

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentListsBinding.bind(view)

        binding.rvItems.layoutManager = LinearLayoutManager(requireContext())
        binding.rvItems.adapter = adapter

        // Pull to refresh
        binding.swipeRefresh.setOnRefreshListener {
            // Simulate refresh
            binding.swipeRefresh.postDelayed({
                adapter.submitList(allItems)
                binding.swipeRefresh.isRefreshing = false
            }, 1000)
        }

        // Chip filter
        binding.chipFilter.setOnCheckedStateChangeListener { _, checkedIds ->
            currentFilter = when (checkedIds.firstOrNull()) {
                R.id.chip_favorites -> "Favorites"
                R.id.chip_active -> "Active"
                else -> "All"
            }
            applyFilter()
        }

        // Search
        binding.searchView.setOnQueryTextListener(object : androidx.appcompat.widget.SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                searchQuery = query?.trim().orEmpty()
                applyFilter()
                return true
            }
            override fun onQueryTextChange(newText: String?): Boolean {
                searchQuery = newText?.trim().orEmpty()
                applyFilter()
                return true
            }
        })

        // Initial load
        applyFilter()
    }

    private fun applyFilter() {
        val filtered = allItems.filter { item ->
            val matchesFilter = when (currentFilter) {
                "Favorites" -> item.isFavorite
                "Active" -> item.category in listOf("Basics", "Forms")
                else -> true
            }
            val matchesSearch = searchQuery.isEmpty() ||
                item.title.contains(searchQuery, ignoreCase = true) ||
                item.description.contains(searchQuery, ignoreCase = true)
            matchesFilter && matchesSearch
        }
        adapter.submitList(filtered.toList())
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
