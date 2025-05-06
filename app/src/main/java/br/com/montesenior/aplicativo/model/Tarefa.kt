package br.com.montesenior.aplicativo.model

data class TarefaItem(
    val imagem: Int,
    val titulo: String,
    val onClick: () -> Unit,
)
