package br.com.montesenior.aplicativo.model

import br.com.montesenior.aplicativo.R

enum class TipoTarefa(
    val id: String,
    val imagem: Int
) {
    LEITURA(
        id = "leitura-conteudo",
        R.drawable.ler_material
    ),VIDEO(
        id = "video-aula",
        R.drawable.assista_o_video
    ),QUIZ(
        id = "quiz",
        R.drawable.prova
    )
}