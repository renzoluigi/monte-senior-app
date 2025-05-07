package br.com.montesenior.aplicativo.repository

import br.com.montesenior.aplicativo.model.VideoAula

object VideoAulaRepository {
    val videoAulas = {
        mapOf(
            "intro_etarismo_video_aula" to VideoAula(
                tituloAula = "Entendendo o etarismo",
                descricaoAula = """
                                    Nesta aula essencial com o Dr. Drauzio Varella,
                                     exploraremos o conceito de etarismo e seus impactos.
                                    Dura├º├úo: 5 minutos
                                    N├¡vel: B├ísico
                                    Instrutor: Dr. Drauzio Varella
                                """.trimIndent(),
                youtubeId = "oyyjgAu_RaI",
                isAssistido = false
            )
        )
    }
}
