package com.resuadam2.watchlistapp.ui.state

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
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

    var currentTitle by mutableStateOf("")
        private set

    var currentPlatform by mutableStateOf(Platforms.OTHERS)
        private set

    var currentType by mutableStateOf(WatchingTypes.SERIES)
        private set

    init {
        // Load form data

    }

    fun onTitleChange(title: String)  {
        currentTitle = title
    }

    fun onPlatformChange(platform: Platforms) {
        currentPlatform = platform
    }

    fun onTypeChange(type: WatchingTypes) {
        currentType = type
    }

    fun canSubmit(): Boolean = currentTitle.isNotBlank()

    fun onSubmit() {
        _formState.update {
            it.copy(
                title = currentTitle,
                platform = currentPlatform,
                type = currentType,
            )
        }
    }
}