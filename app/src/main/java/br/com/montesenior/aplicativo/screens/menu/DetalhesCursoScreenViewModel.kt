package br.com.montesenior.aplicativo.screens.menu

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.model.Matricula
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import com.google.firebase.Timestamp
import kotlinx.coroutines.launch

class DetalhesCursoScreenViewModel: ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    private val _isCarregando = MutableLiveData<Boolean>()
    val isCarregando: LiveData<Boolean> = _isCarregando

    private val _mensagemErro = MutableLiveData<String>()
    val mensagemErro: LiveData<String> = _mensagemErro

    fun onClickMatricular(uid: String, cursoId: String, onSucesso: () -> Unit) {
        _isCarregando.value = true
        _mensagemErro.value = ""

        viewModelScope.launch {
            val matriculaExistente = usuariosRepository.getMatricula(uid, cursoId)
            if (matriculaExistente == null) {
                val novaMatricula = Matricula(
                    cursoId = cursoId,
                    dataMatricula = Timestamp.Companion.now(),
                    progresso = 0.0,
                    concluido = false
                )
                viewModelScope.launch {
                    try {
                        usuariosRepository.adicionarMatricula(uid, novaMatricula)
                        Log.d("DetalhesCursoScreenViewModel", "Matrícula adicionada com sucesso!")
                        _isCarregando.value = false
                        onSucesso()
                    } catch (e: Exception) {
                        Log.e("DetalhesCursoScreenViewModel", "Erro ao adicionar matrícula: ${e.message}")
                        _isCarregando.value = false
                        _mensagemErro.value = "Erro ao adicionar matrícula: ${e.message}"
                    }
                }
            } else {
                Log.d("DetalhesCursoScreenViewModel", "Matrícula já existe!")
                _isCarregando.value = false
                onSucesso()
            }
        }
    }
}