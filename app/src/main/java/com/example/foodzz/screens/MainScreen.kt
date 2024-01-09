package com.example.foodzz.screens

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.SearchBar
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavDestination.Companion.hierarchy
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.example.foodzz.components.BottomNavGraph
import com.example.foodzz.components.BottomNavigationBarIcons

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun MainScreen() {
    val navController = rememberNavController()

    Scaffold (
        topBar = {
            TopBar()
        },
        bottomBar = {
            BottomNavBar(navController)
        }
    ) { values ->
        Column (
            modifier = Modifier
                .padding(values)
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ){
            BottomNavGraph(navController = navController)
        }
    }
}

@Composable
fun BottomNavBar(navController: NavHostController) {
    val screens = listOf(
        BottomNavigationBarIcons.Home,
        BottomNavigationBarIcons.Order,
        BottomNavigationBarIcons.Account
    )

    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val selectedItem = navBackStackEntry?.destination

    BottomNavigation {
        screens.forEach { screen ->
            BottomNavigationItem(
                label = { Text(text = screen.title)},
                selected = selectedItem?.hierarchy?.any {
                    it.route == screen.route
                } == true,
                onClick = { navController.navigate(screen.route) },
                icon = {
                    if (selectedItem?.hierarchy?.any { it.route == screen.route } == true) {
                        Icon(imageVector = screen.selectedIcon, contentDescription = null)
                    } else {
                        Icon(imageVector = screen.unselectedIcon, contentDescription = null)
                    }
                }
            )
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopBar(){
    TopAppBar(
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = Color.Magenta
        ),
        navigationIcon = {
            Icon(imageVector = Icons.Default.LocationOn, contentDescription = "Back arrow")
        },
        title = { Text(text = "Home") },
    )
}