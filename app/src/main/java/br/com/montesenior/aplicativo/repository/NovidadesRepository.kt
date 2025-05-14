package br.com.montesenior.aplicativo.repository

import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.Novidade

object NovidadesRepository {
    val novidades = {
        listOf(
            Novidade(
                id = 1,
                titulo = "Evento AGETS",
                descricao = "O evento agets aconteceu no dia 23232323, as 23232, com a presenca do Dr Antonio Ferreira",
                imagem = R.drawable.evento1,
                link = "https://www.google.com"
            ),
            Novidade(
                id = 2,
                titulo = "Simpósio de Saúde Mental",
                descricao = "O simpósio ocorreu em 12/04/2024, às 10h, com a Dra. Luana Lima falando sobre ansiedade e depressão.",
                imagem = R.drawable.aula_evento,
                link = "https://www.google.com"
            ),
            Novidade(
                id = 3,
                titulo = "Campanha de Vacinação",
                descricao = "A campanha aconteceu em 05/03/2024, das 8h às 16h, com aplicação de vacinas e orientações médicas.",
                imagem = R.drawable.vacinacao,
                link = "https://www.google.com"
            ),
            Novidade(
                id = 4,
                titulo = "Palestra sobre Nutrição",
                descricao = "Realizada em 28/02/2024, às 14h, com a nutricionista Carla Mendes abordando alimentação saudável.",
                imagem = R.drawable.aula_evento,
                link = "https://www.google.com"
            )
        )
    }
}