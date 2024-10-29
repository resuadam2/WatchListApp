package com.resuadam2.watchlistapp.ui.state

import com.resuadam2.watchlistapp.data.Watching

data class WatchinListState(
    val watchingItems: List<Watching> = listOf()
)