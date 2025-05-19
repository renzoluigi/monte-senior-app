package br.com.montesenior.aplicativo.data.model

data class Tarefa(
    val id: String,
    val titulo: String,
    val isConcluida: Boolean,
    val tipo: TipoTarefa
)
