package br.com.montesenior.aplicativo.model

data class Questao(
    val pergunta: String,
    val opcoes: List<String>,
    val posicaoDaCorreta: Int
)
