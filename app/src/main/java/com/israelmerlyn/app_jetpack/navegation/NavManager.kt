package com.israelmerlyn.app_jetpack.navegation


import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.israelmerlyn.app_jetpack.viewModels.Contador.ContadorViewModel
import com.israelmerlyn.app_jetpack.viewModels.corrutinas.CorrutinasViewModels
import com.israelmerlyn.app_jetpack.viewModels.corrutinas.ItemViewModel
import com.israelmerlyn.app_jetpack.viewModels.descuento.CalcularViewModels1
import com.israelmerlyn.app_jetpack.views.descuento.DescuentoView
import com.israelmerlyn.app_jetpack.views.DetailsView
import com.israelmerlyn.app_jetpack.views.HomeView
import com.israelmerlyn.app_jetpack.viewModels.loteria.LoteriaViewModels
import com.israelmerlyn.app_jetpack.views.Contador.ContadorView
import com.israelmerlyn.app_jetpack.views.corrutinas.CorrutinaV1
import com.israelmerlyn.app_jetpack.views.loteria.LoteriaView

@Composable
fun NavMananger() {
    val navController = rememberNavController()
    val viewModel: CalcularViewModels1 = viewModel()
    val viewModelL: LoteriaViewModels = viewModel()
    val viewModelC: ItemViewModel = viewModel()
    val viewModelCont: ContadorViewModel = viewModel()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            HomeView(navController)
        }
        composable("Loteria") {
            LoteriaView(navController, viewModelL)
        }

        composable("Descuento") {
            DescuentoView(navController, viewModel)
        }
        composable("Corrutinas") {
            CorrutinaV1(navController, viewModelC)
        }
        composable("Contador") {
            ContadorView(navController, viewModelCont)
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
