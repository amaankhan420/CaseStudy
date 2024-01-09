package com.example.foodzz.repository

import com.example.foodzz.api.ApiService
import com.example.foodzz.data_classes.ApiResponse
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import javax.inject.Inject

class HomeRepository @Inject constructor(
    private val apiService: ApiService
) {

    private val _data = MutableStateFlow<ApiResponse?>(null)
    val data: StateFlow<ApiResponse?>
        get() = _data

    suspend fun getData() {
        val response = apiService.getData()
        if (response.isSuccessful && response.body() != null) {
            _data.emit(response.body()!!)
        }
    }
}
