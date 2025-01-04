package com.israelmerlyn.app_jetpack.viewModels.corrutinas

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext

class CorrutinasViewModels:ViewModel() {
    var resultState by mutableStateOf("")
        private set
    var isLoading by mutableStateOf(false)

    fun fetchData() {
        viewModelScope.launch {

            try {
                isLoading = true
                llamarAPI()
            } catch (e: Exception) {
                println("error ${e.message}")
            } finally {
                isLoading = false
            }

        }
    }

    private suspend fun llamarAPI() {
        val result = withContext(Dispatchers.IO) {
            delay(5000)
            resultState = "Respuesta de la API"
        }
    }

    fun bloqueoApp() {
        Thread.sleep(5000)
        resultState = "Respuesta de la API"
    }
}