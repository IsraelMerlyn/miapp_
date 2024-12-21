package com.israelmerlyn.app_jetpack.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
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
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.MainButtonD
import com.israelmerlyn.app_jetpack.components.MainIconButton
import com.israelmerlyn.app_jetpack.components.MainTextFIeld
import com.israelmerlyn.app_jetpack.components.SpaceH
import com.israelmerlyn.app_jetpack.components.TitleBar

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DescuentoView(navController: NavController) {
    Scaffold (topBar = {
        TopAppBar(
            title = { TitleBar(name = "Descuento") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.popBackStack()
                }
            }
        )
    }){
        ContentDetailDescuentoView(navController, it)
    }
}

@Composable
fun ContentDetailDescuentoView(navController: NavController, paddingValues: PaddingValues) {

    Column(
        modifier = Modifier
            .padding(paddingValues)
            .padding(10.dp)
            .fillMaxSize(),
//        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
       var precio by remember { mutableStateOf("") }
       var descuento by remember { mutableStateOf("") }
        MainTextFIeld(value = precio, onValueChange = {precio=it}, label = "precio")
        SpaceH()
        MainTextFIeld(value = descuento, onValueChange = {descuento=it}, label = "Descuento")
        SpaceH(10.dp)
        MainButtonD(text = "Generar Descuento") { }
        SpaceH()
        MainButtonD(text = "Limpiar", color = Color.Red) { }
    }
}