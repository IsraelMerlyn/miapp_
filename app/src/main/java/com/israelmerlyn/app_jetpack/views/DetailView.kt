package com.israelmerlyn.app_jetpack.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.MainButton
import com.israelmerlyn.app_jetpack.components.Space
import com.israelmerlyn.app_jetpack.components.TitleBar
import com.israelmerlyn.app_jetpack.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(navController: NavController){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        }
    ) {
        ContentDetailView(navController)

    }
}

@Composable
fun ContentDetailView(navController: NavController){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        Space()
        MainButton(name = "Return Home View", color = Color.White, backColor = Color.Blue) {
           navController.popBackStack()
        }
    }

}


