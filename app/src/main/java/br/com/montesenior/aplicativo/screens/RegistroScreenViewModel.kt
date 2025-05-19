package br.com.montesenior.aplicativo.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class RegistroScreenViewModel : ViewModel() {
    private val _nome = MutableLiveData<String>()
    val nome: LiveData<String> = _nome

    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _genero = MutableLiveData<String>()
    val genero: LiveData<String> = _genero

    private val _telefone = MutableLiveData<String>()
    val telefone: LiveData<String> = _telefone

    private val _isRegistroSucesso = MutableLiveData<Boolean>()
    val isRegistroSucesso: LiveData<Boolean> = _isRegistroSucesso

    private val _mensagemErro = MutableLiveData<String>()
    val mensagemErro: LiveData<String> = _mensagemErro

    fun onNomeChanged(newNome: String) {
        if (newNome.all { it.isLetter() || it.isWhitespace() }) {
            _nome.value = newNome
        }
    }

    fun onEmailChanged(newEmail: String) {
        if (newEmail.contains("@") || newEmail.contains(".") || newEmail.chars().allMatch(Character::isLetterOrDigit)) {
            _email.value = newEmail
        }
    }

    fun onGeneroChanged(newGenero: String) {
        _genero.value = newGenero
    }

    fun onTelefoneChanged(newTelefone: String) {
        if (newTelefone.all { it.isDigit() }) {
            _telefone.value = newTelefone
        }
    }



    fun onClickRegistrar() {
        val nomeValue = _nome.value ?: ""
        val emailValue = _email.value ?: ""
//        val senhaValue = _senha.value ?: ""
//        val confirmarSenhaValue = _confirmarSenha.value ?: ""

        if (
            nomeValue.isEmpty() || emailValue.isEmpty()
//            || senhaValue.isEmpty() || confirmarSenhaValue.isEmpty()
        ) {
            _mensagemErro.value = "Preencha todos os campos"
            return
        }
    }
}