package com.example.qatrainer.kaspresso.screens

import com.example.qatrainer.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KButton
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.edit.KEditText

object FormsScreen : KScreen<FormsScreen>() {
    override val layoutId: Int = R.layout.fragment_forms
    override val viewClass: Class<*> = FormsScreen::class.java

    val emailInput = KEditText { withId(R.id.et_email) }
    val passwordInput = KEditText { withId(R.id.et_password) }
    val submitButton = KButton { withId(R.id.btn_submit) }
    val clearButton = KButton { withId(R.id.btn_clear) }
    val errorText = KTextView { withId(R.id.tv_error) }
    val datePickerButton = KButton { withId(R.id.btn_date_picker) }
    val selectedDateText = KTextView { withId(R.id.tv_selected_date) }
    val countrySpinner = KView { withId(R.id.sp_country) }
}
