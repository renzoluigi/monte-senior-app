package br.com.montesenior.aplicativo.screens.course

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import br.com.montesenior.aplicativo.data.repository.UsuariosRepository
import kotlinx.coroutines.launch

class LeituraConteudoScreenViewModel: ViewModel() {
    private val usuariosRepository = UsuariosRepository()

    fun onClickConcluir(uid: String, cursoId: String, moduloId: String, tarefaId: String) {
        viewModelScope.launch {
            try {
                usuariosRepository.marcarTarefaConcluida(uid, cursoId, moduloId, tarefaId)
                Log.d("LeituraConteudoScreenViewModel", "Tarefa concluída marcada com sucesso!")
            } catch (e: Exception) {
                Log.e("LeituraConteudoScreenViewModel", "Erro ao marcar tarefa concluída", e)
            }
        }
    }
}