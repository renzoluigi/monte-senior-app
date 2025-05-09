package br.com.montesenior.aplicativo.model

data class Tarefa(
    val id: String,
    val imagem: Int,
    val titulo: String,
    val isConcluida: Boolean,
    val tipo: TipoTarefa
)
