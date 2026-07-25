package com.example.qatrainer.ui.challenges

import android.os.Bundle
import android.os.CountDownTimer
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentChallengesBinding
import com.google.android.material.snackbar.Snackbar

class ChallengesFragment : Fragment(R.layout.fragment_challenges) {

    private var _binding: FragmentChallengesBinding? = null
    private val binding get() = _binding!!

    private var timer: CountDownTimer? = null
    private var secondsLeft = 30
    private var progress = 0
    private var expectedStep = 1

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentChallengesBinding.bind(view)

        binding.btnStart.setOnClickListener {
            showReadyDialog()
        }

        setupColorButtons()
    }

    private fun showReadyDialog() {
        AlertDialog.Builder(requireContext())
            .setTitle("Ready?")
            .setMessage("You have 30 seconds to complete the challenge.")
            .setPositiveButton("Yes") { _, _ ->
                startChallenge()
            }
            .setNegativeButton("No") { dialog, _ -> dialog.dismiss() }
            .show()
    }

    private fun startChallenge() {
        // Show Snackbar
        Snackbar.make(binding.root, "Challenge started", Snackbar.LENGTH_SHORT).show()

        // Switch layout
        binding.layoutInitial.visibility = View.GONE
        binding.layoutButtons.visibility = View.VISIBLE

        // Enable buttons, randomize order
        expectedStep = 1
        binding.btnGreen.isEnabled = true
        binding.btnBlue.isEnabled = true
        binding.btnRed.isEnabled = true

        // Start timer
        secondsLeft = 30
        progress = 0
        binding.tvTimer.text = "$secondsLeft"
        binding.progressBar.progress = 0

        timer?.cancel()
        timer = object : CountDownTimer(30_000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                secondsLeft = millisUntilFinished.toInt() / 1000
                binding.tvTimer.text = "$secondsLeft"
            }
            override fun onFinish() {
                binding.tvTimer.text = "0"
                handleFailure()
            }
        }.start()
    }

    private fun setupColorButtons() {
        binding.btnGreen.setOnClickListener { pressButton(1) }
        binding.btnBlue.setOnClickListener { pressButton(2) }
        binding.btnRed.setOnClickListener { pressButton(3) }
    }

    private fun pressButton(step: Int) {
        if (step != expectedStep) {
            // Wrong order
            handleFailure()
            return
        }

        // Correct!
        expectedStep++
        progress += if (expectedStep <= 3) 33 else 34
        binding.progressBar.progress = progress.coerceAtMost(100)

        // Disable pressed button
        when (step) {
            1 -> binding.btnGreen.isEnabled = false
            2 -> binding.btnBlue.isEnabled = false
            3 -> binding.btnRed.isEnabled = false
        }

        if (expectedStep > 3) {
            handleSuccess()
        }
    }

    private fun handleSuccess() {
        timer?.cancel()
        binding.layoutButtons.visibility = View.GONE
        binding.layoutSuccess.visibility = View.VISIBLE
        binding.tvTimer.text = "✓"
        binding.progressBar.progress = 100

        // Simple scale animation
        binding.ivSuccess.animate()
            .scaleX(1.2f).scaleY(1.2f)
            .setDuration(300)
            .withEndAction {
                binding.ivSuccess.animate().scaleX(1.0f).scaleY(1.0f).duration = 200
            }
            .start()

        Toast.makeText(requireContext(), "Challenge completed!", Toast.LENGTH_LONG).show()
    }

    private fun handleFailure() {
        timer?.cancel()

        AlertDialog.Builder(requireContext())
            .setTitle("Retry?")
            .setMessage("Wrong order! Want to try again?")
            .setPositiveButton("Try again") { _, _ ->
                resetChallenge()
            }
            .setNegativeButton("Cancel") { dialog, _ ->
                dialog.dismiss()
                resetChallenge()
            }
            .show()
    }

    private fun resetChallenge() {
        timer?.cancel()
        secondsLeft = 30
        progress = 0
        expectedStep = 1

        binding.tvTimer.text = "30"
        binding.progressBar.progress = 0
        binding.layoutInitial.visibility = View.VISIBLE
        binding.layoutButtons.visibility = View.GONE
        binding.layoutSuccess.visibility = View.GONE

        binding.btnGreen.isEnabled = true
        binding.btnBlue.isEnabled = true
        binding.btnRed.isEnabled = true
    }

    override fun onDestroyView() {
        timer?.cancel()
        super.onDestroyView()
        _binding = null
    }
}
