package br.com.montesenior.aplicativo.model

data class ElementoTrilha(
    val id: String,
    val titulo: String,
    val descricao: String,
    val imagem: Int,
    val tarefas: List<Tarefa>
)