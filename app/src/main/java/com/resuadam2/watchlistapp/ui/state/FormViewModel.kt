package com.resuadam2.watchlistapp.ui.state

import androidx.lifecycle.ViewModel
import com.resuadam2.watchlistapp.data.Platforms
import com.resuadam2.watchlistapp.data.WatchingTypes
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

class FormViewModel : ViewModel() {
    // Form UI state
    private val _formState = MutableStateFlow(FormState())
    val formState: StateFlow<FormState> = _formState.asStateFlow()

    init {
        // Load form data

    }

    fun onTitleChange(title: String) = _formState.update {
        it.copy(title = title)
    }

    fun onPlatformChange(platform: Platforms) = _formState.update {
        it.copy(platform = platform)
    }

    fun onTypeChange(type: WatchingTypes) = _formState.update {
        it.copy(type = type)
    }
}