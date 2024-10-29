package com.resuadam2.watchlistapp.data

data class Watching(
    val id: Int,
    val title: String,
    val watchingType: WatchingTypes,
    val platform: Platforms

)

enum class WatchingTypes {
    FILM, SERIES
}

enum class Platforms {
    NETFLIX, MAX, PRIME, DISNEY, OTHERS
}