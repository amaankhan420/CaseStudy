package com.example.foodzz.api

import com.example.foodzz.data_classes.ApiResponse
import retrofit2.Response
import retrofit2.http.GET


interface ApiService {
    @GET("/v1/0c5d380f-972a-44c9-bd11-ca5a2f154019")
    suspend fun getData(): Response<ApiResponse>
}
