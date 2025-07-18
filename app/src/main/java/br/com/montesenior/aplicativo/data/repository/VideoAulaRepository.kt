package br.com.montesenior.aplicativo.data.repository

import br.com.montesenior.aplicativo.data.model.VideoAula

object VideoAulaRepository {
    val videoAulas = {
        mapOf(
            "intro_etarismo_video_aula" to VideoAula(
                tituloAula = "Entendendo o etarismo",
                descricaoAula = """
                                    Nesta aula essencial com o Dr. Drauzio Varella, exploraremos o conceito de etarismo e seus impactos.
                                    Duração: 5 minutos
                                    Nível: B├ísico
                                    Instrutor: Dr. Drauzio Varella
                                """.trimIndent(),
                youtubeId = "oyyjgAu_RaI",
                isAssistido = false,
                pdfLink = "https://www.google.com",
                exerciosLink = "https://www.google.com",
                linksUteis = "https://www.google.com"
            )
        )
    }
}
