package br.com.montesenior.aplicativo.screens.authentication

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import br.com.montesenior.aplicativo.data.service.CloudinaryService
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory

class CompletarRegistroScreenViewModel : ViewModel() {
    private val auth = Firebase.auth
    private val usuariosRepository = UsuariosRepository()

    private val _tipo = MutableLiveData<String>()
    val tipo: LiveData<String> = _tipo

    private val _endereco = MutableLiveData<String>()
    val endereco: LiveData<String> = _endereco

    private val _dataNascimento = MutableLiveData<String>()
    val dataNascimento: LiveData<String> = _dataNascimento

    private val _senha = MutableLiveData<String>()
    val senha: LiveData<String> = _senha

    private val _confirmarSenha = MutableLiveData<String>()
    val confirmarSenha: LiveData<String> = _confirmarSenha

    private val _mensagemErro = MutableLiveData<String>()
    val mensagemErro: LiveData<String> = _mensagemErro

    private val _isCarregando = MutableLiveData<Boolean>()
    val isCarregando: LiveData<Boolean> = _isCarregando

    private val _isSenhaVisivel = MutableLiveData<Boolean>()
    val isSenhaVisivel: LiveData<Boolean> = _isSenhaVisivel

    private val _isConfirmarSenhaVisivel = MutableLiveData<Boolean>()
    val isConfirmarSenhaVisivel: LiveData<Boolean> = _isConfirmarSenhaVisivel

    fun onTipoChanged(tipo: String) {
        _tipo.value = tipo
    }

    fun onDataNascimentoChanged(newDataNascimento: String) {
        _dataNascimento.value = newDataNascimento
    }

    fun onEnderecoChanged(newEndereco: String) {
        _endereco.value = newEndereco
    }

    fun onSenhaChanged(newSenha: String) {
        _senha.value = newSenha
    }

    fun onConfirmarSenhaChanged(newConfirmarSenha: String) {
        _confirmarSenha.value = newConfirmarSenha
    }

    fun onToggleVisibilidadeSenha() {
        _isSenhaVisivel.value = _isSenhaVisivel.value != true
    }

    fun onToggleVisibilidadeConfirmarSenha() {
        _isConfirmarSenhaVisivel.value = _isConfirmarSenhaVisivel.value != true
    }

    fun onClickConcluir(
        nome: String,
        email: String,
        genero: String,
        telefone: String,
        imagemUrl: String
    ) {
        _isCarregando.value = true
        _mensagemErro.value = ""
        //validacao (TODO)
        if (nome.isEmpty()) {
            _mensagemErro.value = "O nome é obrigatório"
            _isCarregando.value = false
            return
        }
        if (email.isEmpty()) {
            _mensagemErro.value = "O email é obrigatório"
            _isCarregando.value = false
            return
        }
        if (genero.isEmpty()) {
            _mensagemErro.value = "O gênero é obrigatório"
            _isCarregando.value = false
            return
        }
        if (telefone.isEmpty()) {
            _mensagemErro.value = "O telefone é obrigatório"
            _isCarregando.value = false
            return
        }
        if (imagemUrl.isEmpty()) {
            _mensagemErro.value = "Imagem não encontrada"
            _isCarregando.value = false
            return
        }
        if (tipo.value == null) {
            _mensagemErro.value = "O tipo é obrigatório"
            _isCarregando.value = false
            return
        }
        if (endereco.value == null) {
            _mensagemErro.value = "O endereço é obrigatório"
            _isCarregando.value = false
            return
        }
        if (dataNascimento.value == null) {
            _mensagemErro.value = "A data de nascimento é obrigatória"
            _isCarregando.value = false
            return
        }
        if (senha.value == null) {
            _mensagemErro.value = "A senha é obrigatória"
            _isCarregando.value = false
            return
        }
        if (confirmarSenha.value == null) {
            _mensagemErro.value = "A confirmação de senha é obrigatória"
            _isCarregando.value = false
            return
        }
        if (senha.value != confirmarSenha.value) {
            _mensagemErro.value = "As senhas não coincidem"
            _isCarregando.value = false
            return
        }

        auth.createUserWithEmailAndPassword(email, senha.value!!)
            .addOnCompleteListener { registroTask ->
                if (registroTask.isSuccessful) {
                    val uid = auth.currentUser?.uid

                    if (uid != null) {
                        val novoUsuario = Usuario(
                            nome = nome,
                            email = email,
                            endereco = endereco.value!!,
                            telefone = telefone,
                            tipo = tipo.value!!,
                            imagem = imagemUrl,
                            dataNascimento = dataNascimento.value!!,
                            genero = genero
                        )

                        viewModelScope.launch {
                            try {
                                usuariosRepository.adicionarUsuario(uid, novoUsuario)
                                Log.d(
                                    "CompletarRegistroScreenViewModel",
                                    "Usuário registrado com sucesso!"
                                )
                            } catch (e: Exception) {
                                Log.e(
                                    "CompletarRegistroScreenViewModel",
                                    "Erro ao registrar usuário: $e, cadastro no Auth OK"
                                )
                            } finally {
                                _isCarregando.value = false
                            }
                        }
                    } else {
                        Log.e("CompletarRegistroScreenViewModel", "UID do usuário nulo")
                        _mensagemErro.value = "Erro ao obter ID do usuário. Tente novamente."
                        _isCarregando.value = false
                    }
                } else {
                    Log.e(
                        "CompletarRegistroScreenViewModel",
                        "Erro ao registrar usuário: ${registroTask.exception}"
                    )
                    _mensagemErro.value = "Erro ao registrar usuário: ${registroTask.exception}"
                    _isCarregando.value = false
                }
            }
    }
}