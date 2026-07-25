package com.example.qatrainer.kaspresso.screens

import com.example.qatrainer.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.image.KImageView

object DetailScreen : KScreen<DetailScreen>() {
    override val layoutId: Int = R.layout.fragment_detail
    override val viewClass: Class<*> = DetailScreen::class.java

    val detailTitle = KTextView { withId(R.id.tv_detail_title) }
    val detailDesc = KTextView { withId(R.id.tv_detail_desc) }
    val detailImage = KImageView { withId(R.id.iv_detail_image) }
    val backButton = KButton { withId(R.id.btn_back) }
}
