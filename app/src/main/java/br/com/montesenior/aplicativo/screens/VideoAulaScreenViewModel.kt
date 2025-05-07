package br.com.montesenior.aplicativo.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class VideoAulaScreenViewModel : ViewModel() {
    private val _isAssistido = MutableLiveData<Boolean>(false)
    val isAssistido: LiveData<Boolean> = _isAssistido

    fun onVideoEnded(){
        _isAssistido.value = true
    }
}