package com.example.foodzz.components

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.foodzz.screens.AccountScreen
import com.example.foodzz.screens.HomeScreen
import com.example.foodzz.screens.OrderScreen
import com.example.foodzz.viewmodel.HomeViewModel

@Composable
fun BottomNavGraph(navController: NavHostController) {
    val homeViewModel: HomeViewModel = hiltViewModel()
    NavHost(
        navController = navController,
        startDestination = BottomNavigationBarIcons.Home.route
    ) {
        composable(route = BottomNavigationBarIcons.Home.route) {
            HomeScreen(homeViewModel)
        }

        composable(route = BottomNavigationBarIcons.Order.route) {
            OrderScreen()
        }

        composable(route = BottomNavigationBarIcons.Account.route) {
            AccountScreen()
        }
    }
}