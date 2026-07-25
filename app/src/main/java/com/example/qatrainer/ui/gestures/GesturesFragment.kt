package com.example.qatrainer.ui.gestures

import android.graphics.Color
import android.os.Bundle
import android.view.GestureDetector
import android.view.MotionEvent
import android.view.View
import android.widget.PopupMenu
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.qatrainer.R
import com.example.qatrainer.databinding.FragmentGesturesBinding

class GesturesFragment : Fragment(R.layout.fragment_gestures) {

    private var _binding: FragmentGesturesBinding? = null
    private val binding get() = _binding!!

    private lateinit var dragAdapter: DragAdapter
    private var bgColorIndex = 0
    private val bgColors = listOf(
        Color.rgb(187, 195, 255), // primary container
        Color.rgb(255, 218, 185), // orange light
        Color.rgb(200, 230, 201), // green light
        Color.rgb(255, 205, 210), // red light
    )

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _binding = FragmentGesturesBinding.bind(view)

        // 1. ViewPager2
        val pages = listOf(
            "Swipe Gestures" to "Swipe left or right to navigate between pages. Test horizontal swipe in Appium/Kaspresso.",
            "Scroll Testing" to "Scroll down to find elements below the fold. Essential for long-form content testing.",
            "Touch Interactions" to "Long press, double tap, drag & drop — master all gesture types."
        )
        binding.vpGesturePages.adapter = GesturePageAdapter(pages)

        // 2. Horizontal carousel
        val carouselItems = (1..10).map { "Image $it" }
        binding.rvCarousel.apply {
            layoutManager = LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false)
            adapter = CarouselAdapter(carouselItems)
        }

        // 3. Drag & Drop
        dragAdapter = DragAdapter { viewHolder ->
            // long-press starts drag via ItemTouchHelper
        }
        binding.rvDrag.apply {
            layoutManager = LinearLayoutManager(requireContext())
            adapter = dragAdapter
        }

        val touchHelper = ItemTouchHelper(object : ItemTouchHelper.SimpleCallback(
            ItemTouchHelper.UP or ItemTouchHelper.DOWN, 0
        ) {
            override fun onMove(
                recyclerView: androidx.recyclerview.widget.RecyclerView,
                viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder,
                target: androidx.recyclerview.widget.RecyclerView.ViewHolder
            ): Boolean {
                dragAdapter.moveItem(viewHolder.bindingAdapterPosition, target.bindingAdapterPosition)
                return true
            }

            override fun onSwiped(
                viewHolder: androidx.recyclerview.widget.RecyclerView.ViewHolder,
                direction: Int
            ) {}
        })
        touchHelper.attachToRecyclerView(binding.rvDrag)

        // 4. Long press → context menu
        binding.layoutZoomArea.setOnLongClickListener { v ->
            val popup = PopupMenu(requireContext(), v)
            popup.menu.add(0, 1, 0, "Option A")
            popup.menu.add(0, 2, 0, "Option B")
            popup.menu.add(0, 3, 0, "Option C")
            popup.show()
            true
        }

        // 5. Double tap → change background color
        val gestureDetector = GestureDetector(requireContext(), object : GestureDetector.SimpleOnGestureListener() {
            override fun onDoubleTap(e: MotionEvent): Boolean {
                bgColorIndex = (bgColorIndex + 1) % bgColors.size
                binding.layoutZoomArea.setBackgroundColor(bgColors[bgColorIndex])
                return true
            }
        })
        binding.layoutZoomArea.setOnTouchListener { _, event ->
            gestureDetector.onTouchEvent(event)
        }

        // 6. Long scroll content — generate 10x placeholder text
        val scrollText = buildString {
            val base = "Scroll me down! This is a long content area designed to test vertical scrolling gestures. Swipe up to scroll through this text. The QA Trainer app uses this to verify that Appium and Kaspresso can handle scroll gestures correctly. Vertical scrolling is one of the most common gestures in mobile testing. Make sure your test automation framework can find elements that are off-screen and scroll to them.\n\n"
            repeat(10) { append(base) }
        }
        binding.scrollContent.text = scrollText
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}
