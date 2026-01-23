package com.example.juicr.ui

import androidx.lifecycle.viewModelScope
import com.example.juicr.models.Juice
import com.example.juicr.usecases.GetAllJuiceUsecase
import com.example.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllJuiceUsecase: GetAllJuiceUsecase
): BaseViewModel() {
    val juiceList: StateFlow<List<Juice>> = getAllJuiceUsecase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}