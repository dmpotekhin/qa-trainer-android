package com.example.qatrainer.kaspresso.screens

import android.view.View
import com.example.qatrainer.R
import com.kaspersky.kaspresso.screens.KScreen
import io.github.kakaocup.kakao.common.views.KView
import io.github.kakaocup.kakao.text.KTextView
import io.github.kakaocup.kakao.recycler.KRecyclerView
import io.github.kakaocup.kakao.recycler.KRecyclerItem
import org.hamcrest.Matcher

object ListsScreen : KScreen<ListsScreen>() {
    override val layoutId: Int = R.layout.fragment_lists
    override val viewClass: Class<*> = ListsScreen::class.java

    val itemsRecycler = KRecyclerView(
        builder = { withId(R.id.rv_items) },
        itemTypeBuilder = { itemType(::ListItemType) }
    )

    val chipAll = KView { withId(R.id.chip_all) }
    val chipFavorites = KView { withId(R.id.chip_favorites) }
    val searchView = KView { withId(R.id.search_view) }

    class ListItemType(parent: Matcher<View>) : KRecyclerItem<ListItemType>(parent) {
        val title = KTextView(parent) { withId(R.id.tv_item_title) }
        val favoriteBtn = KView(parent) { withId(R.id.btn_favorite) }
    }
}
