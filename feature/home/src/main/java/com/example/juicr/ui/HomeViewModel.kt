package com.example.juicr.ui

import androidx.lifecycle.viewModelScope
import com.example.juicr.models.Juice
import com.example.juicr.usecases.GetAllJuiceUsecase
import com.example.juicr.usecases.SearchJuiceUseCase
import com.example.presentation.BaseViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val getAllJuiceUsecase: GetAllJuiceUsecase,
    private val searchJuiceUseCase: SearchJuiceUseCase
): BaseViewModel() {

    private val _searchState = MutableStateFlow<List<Juice>>(emptyList())
    val searchState: StateFlow<List<Juice>> = _searchState

    val juiceList: StateFlow<List<Juice>> = getAllJuiceUsecase().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    fun searchJuices(query: String){
        viewModelScope.launch {
            val juiceSearchList = searchJuiceUseCase(query).first()
            _searchState.value = juiceSearchList
        }
    }
}