package com.israelmerlyn.app_jetpack.views.corrutinas

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.ViewModel
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.components.MainIconButton
import com.israelmerlyn.app_jetpack.components.TitleBar
import com.israelmerlyn.app_jetpack.viewModels.corrutinas.ItemViewModel
import com.israelmerlyn.app_jetpack.viewModels.corrutinas.CorrutinasViewModels as CorrutinasViewModels1

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CorrutinaV1(navController: NavController, viewModel: CorrutinasViewModels1){
    Scaffold (topBar = {
        TopAppBar(
            title = { TitleBar(name = "Corrutina") }, colors = TopAppBarDefaults.mediumTopAppBarColors(
                containerColor = MaterialTheme.colorScheme.primary
            ),
            navigationIcon = {
                MainIconButton(icon = Icons.Default.ArrowBack) {
                    navController.popBackStack()
                }
            }
        )
    }){
//        ContentDetailDescuentoView(navController, it, viewModel)
//        ItemsView(navController,  viewModel )
        content(navController, viewModel )
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun content(navController: NavController, viewModel: CorrutinasViewModels1) {

        Column(
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally

        ) {
            BotonColor()
            if (viewModel.isLoading) {
                CircularProgressIndicator()
            } else {
                Text(text = viewModel.resultState)
            }
            Button(onClick = { viewModel.fetchData() }) {
                Text(text = "Llamar API")
            }
        }
    }



@Composable
fun BotonColor() {
    var color by remember { mutableStateOf(false) }

    Button(
        onClick = { color = !color }, colors = ButtonDefaults.buttonColors(
            containerColor = if (color) Color.Blue else Color.Red
        )
    ) {
        Text(text = "Boton Color")
    }
}

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ItemsView(navController: NavController, viewModel: ItemViewModel) {
    val itemsList = viewModel.itemList
    val lista by viewModel.lista.collectAsState()
    Scaffold {
    LaunchedEffect(Unit) {
        viewModel.fetchData()
    }

        Column() {
            if (viewModel.isLoading) {
                CircularProgressIndicator()
            } else {
                LazyColumn {
                    items(lista) { item ->
                        Text(text = item.name)
                    }
                }
            }
        }
    }

}

