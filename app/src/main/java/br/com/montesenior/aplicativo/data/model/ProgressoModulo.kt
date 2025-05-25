package br.com.montesenior.aplicativo.data.model

data class ProgressoModulo (
    val moduloId: String,
    val tarefasConcluidas: List<String> = listOf(),
    val concluido: Boolean
)

