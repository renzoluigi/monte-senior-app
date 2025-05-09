package br.com.montesenior.aplicativo.screens

import androidx.lifecycle.ViewModel
import br.com.montesenior.aplicativo.model.Modulo
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuCursoScreenViewModel() : ViewModel() {
    private val _atividades = MutableStateFlow<List<Modulo>>(emptyList())
    val atividades: StateFlow<List<Modulo>> = _atividades

    fun marcarTarefaComoConcluida(atividadeId: String, tarefaId: String) {
        val novaLista = _atividades.value.map { modulo ->
            if (modulo.id == atividadeId) {
                val tarefasAtualizadas = modulo.tarefas.map { tarefa ->
                    if (tarefa.id == tarefaId) tarefa.copy(isConcluida = true) else tarefa
                }
                modulo.copy(tarefas = tarefasAtualizadas)
            } else {
                modulo
            }
        }
        _atividades.value = novaLista
    }
}