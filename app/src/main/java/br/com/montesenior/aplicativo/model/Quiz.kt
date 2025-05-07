package br.com.montesenior.aplicativo.model

data class Quiz(
    val questoes: List<Questao>,
    val pontuacaoNecessaria: Int
)