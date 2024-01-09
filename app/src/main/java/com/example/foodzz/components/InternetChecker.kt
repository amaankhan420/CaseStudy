package com.example.foodzz.components

import android.content.Context
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import android.widget.Toast

class InternetChecker(private val context: Context) {

    fun isInternetAvailable(): Boolean {
        val connectivityManager =
            context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager

        val networkCapabilities = connectivityManager.activeNetwork ?: return false
        val activeNetwork =
            connectivityManager.getNetworkCapabilities(networkCapabilities) ?: return false

        return activeNetwork.hasCapability(NetworkCapabilities.NET_CAPABILITY_INTERNET)
    }

    fun promptUserToTurnOnInternet() {
        Toast.makeText(context, "Please turn on the internet", Toast.LENGTH_SHORT).show()
        // You can add additional logic here to prompt the user to turn on the internet
        // For example, you can open the device settings where the user can enable the internet.
    }
}
