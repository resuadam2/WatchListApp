package com.resuadam2.watchlistapp.ui.state

import androidx.lifecycle.ViewModel
import com.resuadam2.watchlistapp.data.Watching
import com.resuadam2.watchlistapp.data.watchingListExample
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class WatchingListViewModel : ViewModel() {
    // Watching list UI state
    private val _watchingListState = MutableStateFlow(WatchinListState())
    val watchingListState: StateFlow<WatchinListState> = _watchingListState.asStateFlow()

    init {
        // Load watching list
        loadExampleData()
    }

    private fun loadExampleData() {
        _watchingListState.value = WatchinListState(watchingItems = watchingListExample)
    }

    fun deleteWatching(watching: Watching) = _watchingListState.update {
        it.copy(watchingItems = it.watchingItems - watching)
    }


}