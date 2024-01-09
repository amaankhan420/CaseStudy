package com.example.foodzz.screens

import Voucher
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import com.example.foodzz.composables.FoodCategories
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.foodzz.composables.Banners
import com.example.foodzz.composables.OffersCollection
import com.example.foodzz.composables.Restaurant
import com.example.foodzz.data_classes.ApiResponse
import com.example.foodzz.viewmodel.HomeViewModel

@Composable
fun HomeScreen(homeViewModel: HomeViewModel) {
    val state by homeViewModel.homeViewState.collectAsState()
    HomeScreenContent(state)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreenContent(state: ApiResponse?) {
    MaterialTheme {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column {
                Row (
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier
                        .background(Color.Magenta)
                        .fillMaxWidth()
                ){
                    SearchBar(
                        query = "",
                        onQueryChange = {},
                        onSearch = {},
                        active = false,
                        onActiveChange = {},
                        modifier = Modifier
                            .padding(vertical = 3.dp)
                    ) {}
                }
                if (state != null) {
                    Banners(state.data.banners)
                }
                if (state != null) {
                    FoodCategories(state.data.foodCategories)
                }
                if (state != null) {
                    Voucher(state.data.vouchersCount)
                }
                if (state != null) {
                    OffersCollection(state.data.offerCollections)
                }
                if (state != null) {
                    Restaurant(state.data.restaurantCollections)
                }
                Spacer(modifier = Modifier.padding(10.dp))
            }
        }
    }
}