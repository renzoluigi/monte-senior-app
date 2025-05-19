package br.com.montesenior.aplicativo.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch

class UsuarioViewModel: ViewModel() {
    private val _usuarioLogado = MutableStateFlow<Usuario?>(null)
    val usuarioLogado: StateFlow<Usuario?> = _usuarioLogado.asStateFlow()

    fun loginUsuario(usuarioId: String) {
        viewModelScope.launch {
            _usuarioLogado.value = UsuariosRepository().getUsuario(usuarioId)
        }
    }

    fun logoutUsuario() {
        _usuarioLogado.value = null
    }
}