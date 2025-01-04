package com.israelmerlyn.app_jetpack.navegation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.israelmerlyn.app_jetpack.viewModels.CalcularViewModels1
import com.israelmerlyn.app_jetpack.views.DescuentoView
import com.israelmerlyn.app_jetpack.views.DetailsView
import com.israelmerlyn.app_jetpack.views.HomeView
import androidx.activity.viewModels
import androidx.lifecycle.findViewTreeViewModelStoreOwner

@Composable
fun NavMananger() {
    val navController = rememberNavController()
    val viewModel: CalcularViewModels1 = viewModel()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Descuento") {
            DescuentoView(navController, viewModel)
        }
        composable("Details/{id}/?{opcional}", arguments = listOf(
            navArgument("id"){ type=NavType.IntType},
            navArgument("opcional"){ type=NavType.StringType},
        )) {
            val id= it.arguments?.getInt("id")?: 0
            val opcional= it.arguments?.getString("opcional") ?: ""
            DetailsView(navController, id, opcional)
        }
    }
}
