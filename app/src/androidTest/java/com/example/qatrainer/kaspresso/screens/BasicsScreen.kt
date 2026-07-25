package com.example.qatrainer.kaspresso.screens

import com.example.qatrainer.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.switch.KSwitch
import io.github.kakaocup.kakao.check.KCheckBox
import io.github.kakaocup.kakao.image.KImageView

object BasicsScreen : KScreen<BasicsScreen>() {
    override val layoutId: Int = R.layout.fragment_basics
    override val viewClass: Class<*> = BasicsScreen::class.java

    val welcomeText = KTextView { withId(R.id.tv_welcome) }
    val loginButton = KButton { withId(R.id.btn_login) }
    val notificationsSwitch = KSwitch { withId(R.id.sw_notifications) }
    val termsCheckbox = KCheckBox { withId(R.id.cb_terms) }
    val levelRadioGroup = KView { withId(R.id.rg_level) }
    val beginnerRadio = KView { withId(R.id.rb_beginner) }
    val advancedRadio = KView { withId(R.id.rb_advanced) }
    val logoImage = KImageView { withId(R.id.iv_logo) }
    val advancedLayout = KView { withId(R.id.layout_advanced_hidden) }
    val advancedInfoText = KTextView { withId(R.id.tv_advanced_info) }
}
