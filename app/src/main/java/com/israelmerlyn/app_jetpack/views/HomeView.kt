package com.israelmerlyn.app_jetpack.views

import android.annotation.SuppressLint
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.google.android.libraries.places.api.model.Money
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
    val id = 123
    var opcional by remember { mutableStateOf("") }

    // Lista de opciones con íconos
    val options = listOf(
        Option("Descuento", Color.Red, Icons.Default.ShoppingCart, "Descuento"),
        Option("Details", Color.Blue, Icons.Default.Info, "Details/${id}/?${opcional}")
    )

    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            verticalArrangement = Arrangement.spacedBy(16.dp),
            modifier = Modifier.padding(16.dp)
        ) {
            items(options) { option ->
                ListItemWithIcon(
                    name = option.name,
                    icon = option.icon,
                    backColor = option.color,
                    onClick = { navController.navigate(option.route) }
                )
            }
        }
    }
}

@Composable
fun ListItemWithIcon(
    name: String,
    icon: ImageVector,
    backColor: Color,
    onClick: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .background(backColor, shape = RoundedCornerShape(8.dp))
            .clickable { onClick() }
            .padding(16.dp),
        contentAlignment = Alignment.CenterStart
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(12.dp)
        ) {
            Icon(imageVector = icon, contentDescription = null, tint = Color.White)
            Text(text = name, color = Color.White, style = MaterialTheme.typography.bodyLarge)
        }
    }
}

data class Option(
    val name: String,
    val color: Color,
    val icon: ImageVector,
    val route: String
)


