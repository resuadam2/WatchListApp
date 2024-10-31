package com.resuadam2.watchlistapp.data

import androidx.compose.ui.graphics.Color
import com.resuadam2.watchlistapp.ui.components.EnumDisplayable
import com.resuadam2.watchlistapp.ui.theme.AppleBlack
import com.resuadam2.watchlistapp.ui.theme.DisneyBlue
import com.resuadam2.watchlistapp.ui.theme.MAXBlue
import com.resuadam2.watchlistapp.ui.theme.NetflixRed
import com.resuadam2.watchlistapp.ui.theme.OthersGrey
import com.resuadam2.watchlistapp.ui.theme.PrimeBlue
import com.resuadam2.watchlistapp.ui.theme.SkyShowtimePurple

data class Watching(
    val id: Int,
    val title: String,
    val watchingType: WatchingTypes,
    var platform: Platforms


)

enum class WatchingTypes(override val displayName: String) : EnumDisplayable{
    FILM("Film"),
    SERIES("Series")
}

enum class Platforms(override val displayName: String) : EnumDisplayable {
    NETFLIX("Netflix"),
    MAX("HBO Max"),
    PRIME("Prime Video"),
    DISNEY("Disney+"),
    APPLE("Apple TV+"),
    SKY_SHOWTIME("SkyShowtime"),
    OTHERS("Others")
}



val platoform_colors = mapOf<Platforms, Color>(
    Pair(Platforms.NETFLIX, NetflixRed),
    Pair(Platforms.MAX, MAXBlue),
    Pair(Platforms.PRIME, PrimeBlue),
    Pair(Platforms.DISNEY, DisneyBlue),
    Pair(Platforms.APPLE, AppleBlack),
    Pair(Platforms.SKY_SHOWTIME, SkyShowtimePurple),
    Pair(Platforms.OTHERS, OthersGrey)
)

fun getPlatformColor(platform: Platforms): Color {
    return platoform_colors[platform] ?: Color(0xFF444444)
}

val watchingListExample: Set<Watching> = (seriesData + moviesData)

