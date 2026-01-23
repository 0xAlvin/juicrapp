package com.example.presentation

import androidx.lifecycle.ViewModel
import com.example.presentation.components.UiEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharedFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.flow.asStateFlow

abstract class BaseViewModel: ViewModel() {

    protected val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading.asStateFlow()

    private val _event = MutableSharedFlow<UiEvent>()
    val event: SharedFlow<UiEvent> = _event.asSharedFlow()

    protected suspend fun sendEvent(event: UiEvent) {
        _event.emit(event)
    }

    protected suspend fun handleError(e: Throwable) {
        sendEvent(UiEvent.ShowError(e.message ?: "Unknown error"))
    }
}
