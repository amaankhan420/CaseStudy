package com.example.foodzz

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.example.foodzz.components.InternetChecker
import com.example.foodzz.screens.MainScreen
import com.example.foodzz.ui.theme.FoodzzTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val internetChecker = InternetChecker(this)
        if (internetChecker.isInternetAvailable()) {
            setContent {
                FoodzzTheme {
                    MainScreen()
                }
            }
        } else {
            internetChecker.promptUserToTurnOnInternet()
        }
    }
}
