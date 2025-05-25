package br.com.montesenior.aplicativo.data.model

import br.com.montesenior.aplicativo.data.repository.UsuariosRepository

data class Modulo(
    val id: String,
    val titulo: String,
    val descricao: String,
    val imagem: Int,
    val tarefas: List<Tarefa>
)