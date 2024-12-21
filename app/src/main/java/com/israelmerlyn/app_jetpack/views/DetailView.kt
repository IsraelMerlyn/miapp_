package com.israelmerlyn.app_jetpack.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.MainButton
import com.israelmerlyn.app_jetpack.components.MainIconButton
import com.israelmerlyn.app_jetpack.components.Space
import com.israelmerlyn.app_jetpack.components.TitleBar
import com.israelmerlyn.app_jetpack.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailsView(navController: NavController, id:Int , opcional:String?){
    Scaffold (
        topBar = {
            TopAppBar(
                title = { TitleBar(name = "Detail View") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Red
                ),
                navigationIcon = {
                    MainIconButton(icon = Icons.Default.ArrowBack) {
                        navController.popBackStack()
                    }
                }
            )
        }
    ) {
        ContentDetailView(navController, id, opcional)

    }
}

@Composable
fun ContentDetailView(navController: NavController, id: Int, opcional:String?){
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TitleView(name = "Detail View")
        Space()
        TitleView(id.toString())
        Space()
        if(opcional == ""){
            Spacer(modifier = Modifier.height(0.dp))
        }else{
            TitleView(name = opcional.orEmpty())
        }

        MainButton(name = "Return Home View", color = Color.White, backColor = Color.Blue) {
           navController.popBackStack()
        }
    }

}


