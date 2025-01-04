package com.israelmerlyn.app_jetpack.viewModels.Contador

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.israelmerlyn.app_jetpack.models.contador.Contador
import androidx.compose.runtime.State
class ContadorViewModel:ViewModel() {


    // Estado del contador
    private val _contador = mutableStateOf(Contador(0))  // Estado privado del contador
    val contador: State<Contador> = _contador  // Estado público del contador


    // Función para incrementar el contador
    fun incrementar() {
        _contador.value = _contador.value.copy(count = _contador.value.count + 1)
    }

    // Función para decrementar el contador
    fun decrementar() {
        _contador.value = _contador.value.copy(count = _contador.value.count - 1)
    }
}