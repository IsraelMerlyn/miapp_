package com.israelmerlyn.app_jetpack.navegation


import androidx.compose.runtime.Composable
import androidx.navigation.NavController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.israelmerlyn.app_jetpack.views.DetailsView
import com.israelmerlyn.app_jetpack.views.HomeView

@Composable
fun NavMananger() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Details") {
            DetailsView(navController)
        }
    }
}
