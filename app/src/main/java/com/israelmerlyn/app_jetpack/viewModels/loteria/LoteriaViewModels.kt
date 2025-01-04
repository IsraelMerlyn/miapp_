package com.israelmerlyn.app_jetpack.viewModels.loteria

import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class LoteriaViewModels:ViewModel() {
    private  val _lottoNumbers = mutableStateOf(emptyList<Int>())
    val lottoNumber: State<List<Int>> = _lottoNumbers

    fun generateLottoNumber(){
        _lottoNumbers.value= (1..60).shuffled().take(10).sorted()


    }
}