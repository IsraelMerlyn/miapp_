package com.israelmerlyn.app_jetpack.views

import android.annotation.SuppressLint
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.MainIconButton
import com.israelmerlyn.app_jetpack.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescuentoView(navController: NavController) {
    Scaffold (topBar = {
        TopAppBar(
            title = { TitleBar(name = "Descuento") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = Color.Red
            ),
            navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.popBackStack()
                }
            }
        )
    }){
        ContentDetailDescuentoView(navController)
    }
}

@Composable
fun ContentDetailDescuentoView(navController: NavController){

}