package com.example.qatrainer.ui.forms

import android.app.DatePickerDialog
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.fragment.app.Fragment
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentFormsBinding
import java.util.Calendar

class FormsFragment : Fragment(R.layout.fragment_forms) {

    private var _binding: FragmentFormsBinding? = null
    private val binding get() = _binding!!

    private var selectedDate: String? = null

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentFormsBinding.bind(view)

        // Setup Spinner
        val countries = listOf(
            "Select country...", "United States", "United Kingdom",
            "Germany", "France", "Japan", "Brazil", "Australia"
        )
        val adapter = ArrayAdapter(requireContext(), android.R.layout.simple_spinner_item, countries)
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
        binding.spCountry.adapter = adapter

        // DatePicker
        binding.btnDatePicker.setOnClickListener {
            val cal = Calendar.getInstance()
            DatePickerDialog(
                requireContext(),
                { _, year, month, day ->
                    selectedDate = "${day}/${month + 1}/$year"
                    binding.tvSelectedDate.text = selectedDate
                    validateForm()
                },
                cal.get(Calendar.YEAR),
                cal.get(Calendar.MONTH),
                cal.get(Calendar.DAY_OF_MONTH)
            ).show()
        }

        // Text watchers for validation
        val textWatcher = object : TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {}
            override fun afterTextChanged(s: Editable?) { validateForm() }
        }
        binding.etEmail.addTextChangedListener(textWatcher)
        binding.etPassword.addTextChangedListener(textWatcher)

        // Spinner listener
        binding.spCountry.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, pos: Int, id: Long) {
                validateForm()
            }
            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }

        // Submit
        binding.btnSubmit.setOnClickListener {
            Toast.makeText(requireContext(), "Form submitted!", Toast.LENGTH_SHORT).show()
        }

        // Clear
        binding.btnClear.setOnClickListener {
            binding.etEmail.text?.clear()
            binding.etPassword.text?.clear()
            selectedDate = null
            binding.tvSelectedDate.text = "No date selected"
            binding.spCountry.setSelection(0)
            binding.tvError.visibility = View.GONE
        }
    }

    private fun validateForm() {
        val email = binding.etEmail.text.toString().trim()
        val password = binding.etPassword.text.toString()
        val countryPos = binding.spCountry.selectedItemPosition

        val isEmailValid = android.util.Patterns.EMAIL_ADDRESS.matcher(email).matches()
        val isPasswordValid = password.length > 6
        val isCountrySelected = countryPos > 0

        val isValid = isEmailValid && isPasswordValid && isCountrySelected && selectedDate != null

        binding.btnSubmit.isEnabled = isValid

        binding.tvError.visibility = when {
            email.isEmpty() && password.isEmpty() -> View.GONE
            !isEmailValid && email.isNotEmpty() -> {
                binding.tvError.text = "Please enter a valid email"
                View.VISIBLE
            }
            !isPasswordValid && password.isNotEmpty() -> {
                binding.tvError.text = "Password must be > 6 characters"
                View.VISIBLE
            }
            else -> View.GONE
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
