package com.israelmerlyn.app_jetpack.viewModels

import androidx.lifecycle.ViewModel

class CalcularViewModels1:ViewModel() {

    fun calcular(precio:String, descuento: String): Pair<Double, Pair<Double, Boolean>>{
        var precioDescuento = 0.0
        var totalDescuento = 0.0
        var showAlert = false

        if (precio!="" && descuento!= ""){
            precioDescuento = calcularPrecio(precio.toDouble(), descuento.toDouble())
            totalDescuento = calcularDescuento(precio.toDouble(), descuento.toDouble())
        }else{
            showAlert = true
        }
        return  Pair(precioDescuento, Pair(totalDescuento, showAlert))
    }
   private fun calcularPrecio(precio:Double, descuento:Double):Double{
        val res = precio - calcularDescuento(precio, descuento)
        return kotlin.math.round(res * 100) / 100.0

    }

   private fun calcularDescuento(precio:Double, descuento:Double):Double{
        val res = precio * (1 - descuento / 100)
        return kotlin.math.round(res * 100) / 100.0
    }
}