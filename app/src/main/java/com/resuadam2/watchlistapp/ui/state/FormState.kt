package com.resuadam2.watchlistapp.ui.state

import com.resuadam2.watchlistapp.data.Platforms
import com.resuadam2.watchlistapp.data.WatchingTypes

data class FormState (
    val title: String = "",
    val platform: Platforms = Platforms.OTHERS,
    val type: WatchingTypes = WatchingTypes.SERIES,
    val error: String = ""
)