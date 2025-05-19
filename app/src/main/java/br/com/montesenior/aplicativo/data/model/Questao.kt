package br.com.montesenior.aplicativo.data.model

data class Questao(
    val pergunta: String,
    val opcoes: List<String>,
    val posicaoDaCorreta: Int
)
