package br.com.montesenior.aplicativo.data.model

data class Quiz(
    val questoes: List<Questao>,
    val pontuacaoNecessaria: Int
)