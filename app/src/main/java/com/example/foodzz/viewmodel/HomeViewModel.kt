package com.example.foodzz.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.foodzz.data_classes.ApiResponse
import com.example.foodzz.repository.HomeRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(
    private val repository: HomeRepository
) : ViewModel() {

    val homeViewState: StateFlow<ApiResponse?>
        get() = repository.data

    init {
        viewModelScope.launch {
            repository.getData()
        }
    }
}