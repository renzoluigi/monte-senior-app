package br.com.montesenior.aplicativo.screens

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.model.Usuario
import br.com.montesenior.aplicativo.repository.UsuariosRepository
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
    val usuariosRepository = UsuariosRepository()
    private val auth: FirebaseAuth = Firebase.auth

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

    private val _isCarregando = MutableLiveData<Boolean>()
    val isCarregando: LiveData<Boolean> = _isCarregando

    fun onEmailChanged(newEmail: String) {
        _email.value = newEmail
        _mensagemErro.value = ""
    }

    fun onSenhaChanged(newSenha: String) {
        _senha.value = newSenha
        _mensagemErro.value = ""
    }


    fun onToggleVisibilidadeSenha() {
        _isSenhaVisivel.value = _isSenhaVisivel.value != true
    }

    fun onClickEntrar() {
        val emailValue = _email.value ?: ""
        val senhaValue = _senha.value ?: ""

        if (emailValue.isEmpty() || senhaValue.isEmpty()) {
            _mensagemErro.value = "Preencha todos os campos"
            return
        }

        _isCarregando.value = true
        _mensagemErro.value = ""

        viewModelScope.launch {
            try {
                auth.signInWithEmailAndPassword(emailValue, senhaValue)
                    .addOnCompleteListener { loginTask ->
                        _isCarregando.value = false
                        if (loginTask.isSuccessful) {
                            Log.d("Login", "signInWithEmail success")
                            _isAutorizado.value = true
                            _mensagemErro.value = "Login bem-sucedido"
                            viewModelScope.launch {
                                usuariosRepository.adicionarUsuario(
                                    Usuario(
                                        uid = "renzo_luigi",
                                        nome = "Renzo Luigi",
                                        email = "renzooluigi@hotmail.com",
                                        endereco = "Rua Onze de Abril",
                                        telefone = "11952408932",
                                        imagem = "https://github.com/renzooluigi.png",
                                        dataNascimento = "22/10/2000"
                                    )
                                )
                            }
                        } else {
                            Log.w("Login", "signInWithEmail:failure", loginTask.exception)
                            _mensagemErro.value = "Falha no login: ${loginTask.exception?.message}"
                            _isAutorizado.value = false
                        }
                    }
            }
            catch (e: Exception) {
                Log.e("LoginViewModel", "Erro inesperado no onClickEntrar", e)
                _mensagemErro.value = "Erro inesperado: ${e.message}"
                _isCarregando.value = false
                _isAutorizado.value = false
            }
        }
    }
}