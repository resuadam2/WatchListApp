package com.resuadam2.watchlistapp.data

import androidx.compose.ui.graphics.Color
import com.resuadam2.watchlistapp.ui.theme.AppleGrey
import com.resuadam2.watchlistapp.ui.theme.DisneyBlue
import com.resuadam2.watchlistapp.ui.theme.MAXBlue
import com.resuadam2.watchlistapp.ui.theme.NetflixRed
import com.resuadam2.watchlistapp.ui.theme.OthersGrey
import com.resuadam2.watchlistapp.ui.theme.PrimeBlue
import com.resuadam2.watchlistapp.ui.theme.SkyShowtimeBlack

data class Watching(
    val id: Int,
    val title: String,
    val watchingType: WatchingTypes,
    var platform: Platforms


)

enum class WatchingTypes {
    FILM, SERIES
}

enum class Platforms {
    NETFLIX, MAX, PRIME, DISNEY, APPLE, SKY_SHOWTIME, OTHERS
}

val platoform_colors = mapOf<Platforms, Color>(
    Pair(Platforms.NETFLIX, NetflixRed),
    Pair(Platforms.MAX, MAXBlue),
    Pair(Platforms.PRIME, PrimeBlue),
    Pair(Platforms.DISNEY, DisneyBlue),
    Pair(Platforms.APPLE, AppleGrey),
    Pair(Platforms.SKY_SHOWTIME, SkyShowtimeBlack),
    Pair(Platforms.OTHERS, OthersGrey)
)

fun getPlatformColor(platform: Platforms): Color {
    return platoform_colors[platform] ?: Color(0xFF444444)
}

val watchingListExample: Set<Watching> = (seriesData + moviesData)

