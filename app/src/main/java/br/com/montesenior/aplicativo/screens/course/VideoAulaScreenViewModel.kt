package br.com.montesenior.aplicativo.screens.course

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.launch

class VideoAulaScreenViewModel : ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    private val _isAssistido = MutableLiveData<Boolean>(false)
    val isAssistido: LiveData<Boolean> = _isAssistido

    fun onVideoEnded(){
        _isAssistido.value = true
    }

    fun onClickConcluir(uid: String, cursoId: String, moduloId: String, tarefaId: String){
        viewModelScope.launch {
            try {
                usuariosRepository.marcarTarefaConcluida(uid, cursoId, moduloId, tarefaId)
                Log.d("VideoAulaScreenViewModel", "Tarefa concluída com sucesso: $tarefaId")
            } catch (e: Exception) {
                Log.e("VideoAulaScreenViewModel", "Erro ao marcar tarefa concluída", e)
            }
        }
    }
}