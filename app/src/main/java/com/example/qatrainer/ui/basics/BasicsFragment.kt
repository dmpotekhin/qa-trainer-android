package com.example.qatrainer.ui.basics

import android.os.Bundle
import android.view.View
import android.widget.RadioButton
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentBasicsBinding

class BasicsFragment : Fragment(R.layout.fragment_basics) {

    private var _binding: FragmentBasicsBinding? = null
    private val binding get() = _binding!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentBasicsBinding.bind(view)

        // Login button - shows toast
        binding.btnLogin.setOnClickListener {
            Toast.makeText(requireContext(), "Success!", Toast.LENGTH_SHORT).show()
        }

        // RadioGroup - show/hide advanced section
        binding.rgLevel.setOnCheckedChangeListener { _, checkedId ->
            val isAdvanced = checkedId == R.id.rb_advanced
            binding.layoutAdvancedHidden.visibility = if (isAdvanced) View.VISIBLE else View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
