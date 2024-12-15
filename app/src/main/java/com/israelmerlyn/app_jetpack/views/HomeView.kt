package com.israelmerlyn.app_jetpack.views

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.israelmerlyn.app_jetpack.components.ActionButton
import com.israelmerlyn.app_jetpack.components.MainButton
import com.israelmerlyn.app_jetpack.components.Space
import com.israelmerlyn.app_jetpack.components.TitleBar
import com.israelmerlyn.app_jetpack.components.TitleView

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView() {

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
        ContentHomeView()
    }
}

@Composable
fun ContentHomeView() {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Home View")
        Space()
        MainButton(name = "Details View", color = Color.White, backColor = Color.Red) {
            println("btn generico")
        }
    }
}

