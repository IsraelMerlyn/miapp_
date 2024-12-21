package com.israelmerlyn.app_jetpack.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.ActionButton
import com.israelmerlyn.app_jetpack.components.MainButton
import com.israelmerlyn.app_jetpack.components.Space
import com.israelmerlyn.app_jetpack.components.TitleBar
import com.israelmerlyn.app_jetpack.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView(navController: NavController) {

    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = { TitleBar(name = "Home") },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton()
        }
    ) {
        ContentHomeView(navController)
    }
}
@Composable
fun AppDescuento(navController: NavController){

}
@Composable
fun ContentHomeView(navController: NavController) {
    val id=123
    var opcional by remember { mutableStateOf(
        "" ) }
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {


//        TextField(value = opcional, onValueChange = {opcional = it} , label = { Text(text = "Opcional") })

        MainButton(name = "Descuento", color = Color.White, backColor = Color.Red) {
          navController.navigate("Descuento")
        }
        MainButton(name = "Details", color = Color.White, backColor = Color.Blue) {
            navController.navigate("Details/${id}/?${opcional}")
        }
    }
}

