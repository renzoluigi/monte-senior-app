package br.com.montesenior.aplicativo.model

data class Tarefa(
    val id: String,
    val imagem: Int,
    val titulo: String,
    val onClick: () -> Unit,
    val isConcluida: Boolean,
    val tipo: TipoTarefa
)
