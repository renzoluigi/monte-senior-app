package br.com.montesenior.aplicativo.screens

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class LoginScreenViewModel : ViewModel() {
    private val _email = MutableLiveData<String>()
    val email: LiveData<String> = _email

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    private val _mensagemErro = MutableLiveData<String>()
    val mensagemErro: LiveData<String> = _mensagemErro

    private val _isSenhaVisivel = MutableLiveData<Boolean>()
    val isSenhaVisivel: LiveData<Boolean> = _isSenhaVisivel

    private val _isAutorizado = MutableLiveData<Boolean>()
    val isAutorizado: LiveData<Boolean> = _isAutorizado

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
    }

    fun onSenhaChanged(newSenha: String) {
        _senha.value = newSenha
    }

    fun onClickEntrar(){
        if (email.value.isNullOrEmpty() || senha.value.isNullOrEmpty()){
            _mensagemErro.value = "Preencha todos os campos"
        }
        else{
            if (email.value == "admin" && senha.value == "admin"){
                _isAutorizado.value = true
                _mensagemErro.value = "Login realizado com sucesso!"
            }
            else{
                _mensagemErro.value = "Email ou senha incorretos"
            }
        }
    }

    fun onToggleVisibilidadeSenha() {
        _isSenhaVisivel.value = !(_isSenhaVisivel.value ?: false)
    }
}