package com.senac.calculadora.viewmodel

import androidx.lifecycle.ViewModel
import com.senac.calculadora.model.Tip
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import java.time.temporal.TemporalAmount

class TipViewModel : ViewModel(){

    private val _uiState = MutableStateFlow(Tip())
    val uiState : StateFlow<Tip> = _uiState.asStateFlow()

    fun updateAmount(newAmount: Float){
        _uiState.update {
            it.copy(amount = newAmount)
        }
    }

    fun updateCustom(newCustom: Int){
        _uiState.update {
            it.copy(custom = newCustom)
        }
    }

}