package com.israelmerlyn.app_jetpack.views.Contador

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue

import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.israelmerlyn.app_jetpack.viewModels.Contador.ContadorViewModel

@OptIn(ExperimentalMaterial3Api::class)
@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@Composable
fun ContadorView(navController: NavController, contadorViewModel: ContadorViewModel = viewModel()) {

    // Obtenemos el estado actual del contador
    val contador by contadorViewModel.contador

    // Interfaz de usuario
    Scaffold(
        topBar = {
            TopAppBar(title = { Text("Contador MVVM") })
        },
        content = {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "Contador: ${contador.count}",
                    style = MaterialTheme.typography.bodyLarge,
                    modifier = Modifier.padding(16.dp)
                )

                Row(
                    horizontalArrangement = Arrangement.Center,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Button(onClick = { contadorViewModel.decrementar() }) {
                        Text("Decrementar")
                    }

                    Spacer(modifier = Modifier.width(16.dp))

                    Button(onClick = { contadorViewModel.incrementar() }) {
                        Text("Incrementar")
                    }
                }
            }
        }
    )
}

