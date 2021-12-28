package dev.gabrielhenrique.hibridapplication

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.flow.MutableStateFlow

class MainActivityViewModel: ViewModel() {

    val counterFlow = MutableStateFlow(0)

    val counterLiveData = MutableLiveData(0)

    fun increaseCounter() {
        counterFlow.tryEmit(counterFlow.value + 1)
        counterLiveData.value = counterLiveData.value!! + 1
    }
}