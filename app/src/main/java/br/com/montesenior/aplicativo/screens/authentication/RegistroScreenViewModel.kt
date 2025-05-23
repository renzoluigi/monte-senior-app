package br.com.montesenior.aplicativo.screens.authentication

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

    private val _mensagemErro = MutableLiveData<String>()
    val mensagemErro: LiveData<String> = _mensagemErro

    fun onNomeChanged(newNome: String) {
        if (newNome.all { it.isLetter() || it.isWhitespace() }) {
            _nome.value = newNome
            _mensagemErro.value = ""
        }
    }

    fun onEmailChanged(newEmail: String) {
        if (newEmail.contains("@") || newEmail.contains(".") || newEmail.chars().allMatch(Character::isLetterOrDigit)) {
            _email.value = newEmail
            _mensagemErro.value = ""
        }
    }

    fun onGeneroChanged(newGenero: String) {
        _genero.value = newGenero
        _mensagemErro.value = ""
    }

    fun onTelefoneChanged(newTelefone: String) {
        if (newTelefone.all { it.isDigit() } && newTelefone.length < 12) {
            _telefone.value = newTelefone
            _mensagemErro.value = ""
        }
    }



    fun onClickContinuar(onClick: () -> Unit) {
        val nomeValue = _nome.value ?: ""
        val emailValue = _email.value ?: ""
        val telefoneValue = _telefone.value ?: ""
        val generoValue = _genero.value ?: ""

        if (
            nomeValue.isEmpty() || emailValue.isEmpty() ||
            telefoneValue.isEmpty() || generoValue.isEmpty()
        ) {
            _mensagemErro.value = "Preencha todos os campos"
            return
        }
        if (nomeValue.length < 3) {
            _mensagemErro.value = "O nome deve ter pelo menos 3 caracteres"
            return
        }
        if (!emailValue.contains("@")) {
            _mensagemErro.value = "O email deve ser válido"
            return
        }
        if (telefoneValue.length < 11) {
            _mensagemErro.value = "O telefone deve ser válido"
            return
        }
        onClick()

    }
}