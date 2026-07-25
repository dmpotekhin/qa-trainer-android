package com.example.qatrainer.kaspresso.screens

import com.example.qatrainer.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.progress.KProgressBar

object ChallengesScreen : KScreen<ChallengesScreen>() {
    override val layoutId: Int = R.layout.fragment_challenges
    override val viewClass: Class<*> = ChallengesScreen::class.java

    val timerText = KTextView { withId(R.id.tv_timer) }
    val progressBar = KProgressBar { withId(R.id.progress_bar) }
    val startButton = KButton { withId(R.id.btn_start) }
    val greenButton = KButton { withId(R.id.btn_green) }
    val blueButton = KButton { withId(R.id.btn_blue) }
    val redButton = KButton { withId(R.id.btn_red) }
    val completedText = KTextView { withId(R.id.tv_completed) }
}
