package com.israelmerlyn.app_jetpack

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.israelmerlyn.app_jetpack.navegation.NavMananger
import com.israelmerlyn.app_jetpack.ui.theme.App_JetpackTheme
import com.israelmerlyn.app_jetpack.views.DetailsView
import com.israelmerlyn.app_jetpack.views.HomeView

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            NavMananger()
        }
    }
}

