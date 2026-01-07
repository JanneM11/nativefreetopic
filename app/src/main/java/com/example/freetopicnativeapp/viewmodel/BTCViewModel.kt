package com.example.freetopicnativeapp.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.freetopicnativeapp.model.BTC
import com.example.freetopicnativeapp.model.BTCApi
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

sealed interface BTCState {
    object Loading : BTCState
    data class Success(val btc: BTC) : BTCState
    data class Error(val message: String) : BTCState
}
class BTCViewModel : ViewModel() {

    private val _title = MutableStateFlow("Bitcoin hinta")
    val title = _title.asStateFlow()
    private val _state = MutableStateFlow<BTCState>(BTCState.Loading)
    val state = _state.asStateFlow()

    init {
        startAutoRefresh()
    }

    private fun startAutoRefresh() {
        viewModelScope.launch {
            while (true) {
                getBTC()
                delay(30_000)
            }
        }
    }


    private suspend fun getBTC() {
            try {
                _state.value = BTCState.Loading
                val api = BTCApi.getInstance()
                val result = api.getBTC()
                val btc = result.firstOrNull()
                if (btc != null) {
                    _state.value = BTCState.Success(btc)
                } else {
                    _state.value = BTCState.Error("BTC data missing")
                }
            } catch (e: Exception) {
                Log.d("BTCVIEWMODEL", e.message.toString())
                _state.value = BTCState.Error("Error retrieving data from API.")
            }
        }
    }


