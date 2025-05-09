package br.com.montesenior.aplicativo.repository

import br.com.montesenior.aplicativo.model.Questao
import br.com.montesenior.aplicativo.model.Quiz

object QuizRepository {
    val quizzes = mapOf(
        "intro_etarismo_quiz" to Quiz(
            questoes = listOf(
                Questao(
                    pergunta = "O que é etarismo?",
                    opcoes = listOf(
                        "Um tipo de exercício físico para idosos",
                        "Discriminação baseada na idade",
                        "Um m├⌐todo de cuidado geriátrico"
                    ),
                    posicaoDaCorreta = 1
                ),
                Questao(
                    pergunta = "Qual destes é um exemplo de etarismo?",
                    opcoes = listOf(
                        "Oferecer assento priorit├írio no transporte público",
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
                    pergunta = "O que é etarismo?",
                    opcoes = listOf(
                        "Um tipo de exercício físico para idosos",
                        "Discriminação baseada na idade",
                        "Um método de cuidado geriátrico"
                    ),
                    posicaoDaCorreta = 1
                ),
                Questao(
                    pergunta = "Qual destes é um exemplo de etarismo?",
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
