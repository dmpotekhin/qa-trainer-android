package com.example.qatrainer.ui.lists

data class ListItem(
    val id: Int,
    val title: String,
    val description: String,
    val category: String,
    var isFavorite: Boolean = false
) {
    companion object {
        fun sampleData(): List<ListItem> = listOf(
            ListItem(1, "Appium Locator Strategy", "Master ID, XPath, accessibility ID, class name selectors", "Basics"),
            ListItem(2, "Kaspresso KView", "Learn to use KView matchers for reliable View assertions", "Basics"),
            ListItem(3, "Page Object Model", "Design pattern for organizing test code with POM", "Basics"),
            ListItem(4, "TestNG Annotations", "BeforeClass, BeforeMethod, Test, DataProvider workflows", "Basics"),
            ListItem(5, "Form Input Testing", "Validate text fields, date pickers, spinners", "Forms"),
            ListItem(6, "Email Validation", "Test email field with valid/invalid input patterns", "Forms"),
            ListItem(7, "Password Toggle", "Test secure text entry and visibility toggle", "Forms"),
            ListItem(8, "Clear Button Behavior", "Verify all form fields reset on clear", "Forms"),
            ListItem(9, "RecyclerView Scrolling", "Programmatic scroll to position and assertion", "Lists"),
            ListItem(10, "Pull to Refresh", "SwipeRefreshLayout gesture testing", "Lists"),
            ListItem(11, "Search Filtering", "Real-time list filtering via SearchView", "Lists"),
            ListItem(12, "Item Click Navigation", "Shared element transitions and detail screens", "Lists"),
            ListItem(13, "ViewPager Swipe", "Horizontal swipe between pages with assertions", "Gestures"),
            ListItem(14, "Drag and Drop", "ItemTouchHelper callback for reordering items", "Gestures"),
            ListItem(15, "Long Press Menu", "Context menu via PopupMenu on long press", "Gestures"),
            ListItem(16, "Pinch to Zoom", "GestureDetector for scale gestures on images", "Gestures"),
            ListItem(17, "Double Tap", "GestureDetector.SimpleOnGestureListener double tap", "Gestures"),
            ListItem(18, "Timer Testing", "CountDownTimer with UI thread updates", "Challenges"),
            ListItem(19, "Dialog Interaction", "AlertDialog with positive/negative button handling", "Challenges"),
            ListItem(20, "Snackbar Assertions", "Verify Snackbar text and action button", "Challenges"),
            ListItem(21, "Button Sequence", "Verify multi-step UI flow with state management", "Challenges"),
            ListItem(22, "Progress Tracking", "ProgressBar updates across sequential operations", "Challenges"),
            ListItem(23, "RadioGroup Selection", "Validate single-selection RadioGroup behavior", "Basics"),
            ListItem(24, "Checkbox State", "Checkbox toggle and getCheckedState verification", "Basics"),
            ListItem(25, "Toast Messages", "Toast assertion helpers for short-lived messages", "Basics"),
        )
    }
}
