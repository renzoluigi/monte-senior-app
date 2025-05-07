package br.com.montesenior.aplicativo.repository

import br.com.montesenior.aplicativo.model.Questao
import br.com.montesenior.aplicativo.model.Quiz

object QuizRepository {
    val quizzes = mapOf(
        "intro_etarismo_quiz" to Quiz(
            questoes = listOf(
                Questao(
                    pergunta = "O que ├⌐ etarismo?",
                    opcoes = listOf(
                        "Um tipo de exerc├¡cio f├¡sico para idosos",
                        "Discrimina├º├úo baseada na idade",
                        "Um m├⌐todo de cuidado geri├ítrico"
                    ),
                    posicaoDaCorreta = 1
                ),
                Questao(
                    pergunta = "Qual destes ├⌐ um exemplo de etarismo?",
                    opcoes = listOf(
                        "Oferecer assento priorit├írio no transporte p├║blico",
                        "Adaptar ambientes para mobilidade reduzida",
                        "Considerar idosos incapazes de aprender tecnologia"
                    ),
                    posicaoDaCorreta = 2
                )
            ),
            pontuacaoNecessaria = 100
        ),
        "inclusao_etarismo_quiz" to Quiz(
            questoes = listOf(
                Questao(
                    pergunta = "O que ├⌐ etarismo?",
                    opcoes = listOf(
                        "Um tipo de exerc├¡cio f├¡sico para idosos",
                        "Discrimina├º├úo baseada na idade",
                        "Um m├⌐todo de cuidado geri├ítrico"
                    ),
                    posicaoDaCorreta = 1
                ),
                Questao(
                    pergunta = "Qual destes ├⌐ um exemplo de etarismo?",
                    opcoes = listOf(
                        "CD",
                        "ABC",
                        "Considerar idosos incapazes de aprender tecnologia"
                    ),
                    posicaoDaCorreta = 2
                )
            ),
            pontuacaoNecessaria = 100
        )
    )
}
