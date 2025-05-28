package br.com.montesenior.aplicativo.screens.authentication

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthException
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.launch

class LoginScreenViewModel : ViewModel() {
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

    private val _uid = MutableLiveData<String?>()
    val uid: LiveData<String?> = _uid

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
        var uid = ""


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
                            uid = loginTask.result.user?.uid ?: ""
                            if (uid.isNotBlank()) {
                                _uid.value = loginTask.result.user?.uid
                                _isAutorizado.value = true
                                _mensagemErro.value = "Login bem-sucedido"
                            } else {
                                Log.w("LoginViewModel", "UID nulo apos login bem-sucedido")
                                _mensagemErro.value = "Falha no login: UID vazio"
                                _isAutorizado.value = false
                            }
                        } else {
                            val exception = loginTask.exception
                            if (exception != null) {
                                val errorCode = (exception as? FirebaseAuthException)?.errorCode
                                    ?: "ERROR_UNKNOWN"
                                Log.w("Login", "signInWithEmail:failure", loginTask.exception)
                                _mensagemErro.value = getMensagemErro(errorCode)
                                _isAutorizado.value = false
                            }
                        }
                    }
            } catch (e: Exception) {
                Log.e("LoginViewModel", "Erro inesperado no onClickEntrar", e)
                _mensagemErro.value = getMensagemErro(e.message ?: "ERROR_UNKNOWN")
                _uid.value = null
                _isCarregando.value = false
                _isAutorizado.value = false
            }
        }
    }

    private fun getMensagemErro(errorCode: String): String {
        return when (errorCode) {
            "ERROR_INVALID_CREDENTIAL" -> "Credenciais inválidas. Verifique seu e-mail e senha."
            "ERROR_INVALID_EMAIL" -> "Email inválido."
            "ERROR_WRONG_PASSWORD" -> "Senha incorreta."
            "ERROR_USER_NOT_FOUND" -> "Usuário não encontrado."
            "ERROR_USER_DISABLED" -> "Esta conta foi desabilitada."
            "ERROR_TOO_MANY_REQUESTS" -> "Muitas tentativas. Tente novamente mais tarde."
            "ERROR_OPERATION_NOT_ALLOWED" -> "Login não permitido, contate o suporte."
            "ERROR_UNKNOWN" -> "Erro desconhecido"
            "ERROR_UNEXPECTED" -> "Erro inesperado."
            "ERROR_NETWORK_UNAVAILABLE" -> "Sem conexão com a internet. Verifique sua conexão e tente novamente."
            else -> "Falha no login: $errorCode"
        }
    }
}

// -> max attemps