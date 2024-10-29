package com.resuadam2.watchlistapp.ui.state

import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow

class WatchingListViewModel : ViewModel() {
    // Watching list UI state
    private val _watchingListState = MutableStateFlow(WatchinListState())
    val watchingListState: StateFlow<WatchinListState> = _watchingListState.asStateFlow()


}