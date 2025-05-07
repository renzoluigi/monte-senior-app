package br.com.montesenior.aplicativo.screens

import androidx.lifecycle.ViewModel
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.Modulo
import br.com.montesenior.aplicativo.model.Tarefa
import br.com.montesenior.aplicativo.model.TipoTarefa
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class MenuCursoScreenViewModel() : ViewModel() {
    private val _atividades = MutableStateFlow<List<Modulo>>(emptyList())
    val atividades: StateFlow<List<Modulo>> = _atividades

    init {
        _atividades.value = listOf(
            Modulo(
                id = "intro",
                titulo = "Introdução",
                descricao = "Uma visão geral dos principais tópicos" +
                        " que abordaremos para te ajudar no dia a dia do cuidado.",
                imagem = R.drawable.didatic,
                tarefas = listOf(
                    Tarefa(
                        id = "intro_material",
                        tipo = TipoTarefa.LEITURA,
                        titulo = "Leia o  Material",
                        imagem = R.drawable.ler_material,
                        isConcluida = false,
                        onClick = {

                        }
                    ),
                    Tarefa(
                        id = "intro_etarismo_video_aula",
                        tipo = TipoTarefa.VIDEO,
                        titulo = "Vídeo Introdutório",
                        imagem = R.drawable.assista_o_video,
                        isConcluida = false,
                        onClick = {

                        }
                    ),
                    Tarefa(
                        id = "intro_etarismo_quiz",
                        tipo = TipoTarefa.QUIZ,
                        titulo = "Quiz Introdutório",
                        imagem = R.drawable.prova,
                        isConcluida = false,
                        onClick = {

                        }
                    )
                )
            ),
            Modulo(
                id = "habilidades",
                titulo = "Habilidades Básicas de Cuidado",
                descricao = "Desenvolva as habilidades" +
                        " essenciais que todo cuidador de idosos" +
                        " precisa para garantir o conforto, a segurança e o bem-estar " +
                        "no dia a dia.",
                imagem = R.drawable.habilidade,
                tarefas = listOf(
                    Tarefa(
                        id = "intro_video",
                        tipo = TipoTarefa.VIDEO,
                        titulo = "Assistir ao Vídeo",
                        imagem = R.drawable.assista_o_video,
                        isConcluida = false,
                        onClick = {

                        }
                    ),
                    Tarefa(
                        id = "inclusao_etarismo_quiz",
                        tipo = TipoTarefa.QUIZ,
                        titulo = "Responder o Quiz",
                        imagem = R.drawable.prova,
                        isConcluida = false,
                        onClick = {

                        }
                    )
                )
            )
        )
    }

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