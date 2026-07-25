package com.example.qatrainer.ui.detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentDetailBinding

class DetailFragment : Fragment(R.layout.fragment_detail) {

    private var _binding: FragmentDetailBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentDetailBinding.bind(view)

        val itemTitle = arguments?.getString("itemTitle") ?: "Detail"
        val itemDesc = arguments?.getString("itemDesc") ?: ""

        binding.collapsingToolbar.title = itemTitle
        binding.tvDetailTitle.text = itemTitle
        binding.tvDetailDesc.text = itemDesc

        binding.btnBack.setOnClickListener {
            requireActivity().onBackPressedDispatcher.onBackPressed()
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
