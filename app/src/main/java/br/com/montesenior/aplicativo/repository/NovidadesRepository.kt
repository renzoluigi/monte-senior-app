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
                imagem = R.drawable.evento1
            ),
            Novidade(
                id = 2,
                titulo = "Simpósio de Saúde Mental",
                descricao = "O simpósio ocorreu em 12/04/2024, às 10h, com a Dra. Luana Lima falando sobre ansiedade e depressão.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 3,
                titulo = "Campanha de Vacinação",
                descricao = "A campanha aconteceu em 05/03/2024, das 8h às 16h, com aplicação de vacinas e orientações médicas.",
                imagem = R.drawable.vacinacao
            ),
            Novidade(
                id = 4,
                titulo = "Palestra sobre Nutrição",
                descricao = "Realizada em 28/02/2024, às 14h, com a nutricionista Carla Mendes abordando alimentação saudável.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 5,
                titulo = "Semana da Enfermagem",
                descricao = "O evento ocorreu entre 10 e 14/05/2024, com oficinas práticas, palestras e rodas de conversa.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 6,
                titulo = "Oficina de Primeiros Socorros",
                descricao = "A oficina foi realizada em 21/01/2024, às 9h, com demonstrações práticas e instruções de emergência.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 7,
                titulo = "Encontro de Saúde da Mulher",
                descricao = "Aconteceu em 08/03/2024, às 15h, com palestras sobre prevenção e autocuidado feminino.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 8,
                titulo = "Feira de Saúde Pública",
                descricao = "A feira foi em 19/06/2024, às 10h, com atendimentos gratuitos e orientação sobre doenças comuns.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 9,
                titulo = "Seminário de Doenças Crônicas",
                descricao = "O seminário ocorreu em 04/07/2024, às 13h, com foco em diabetes, hipertensão e prevenção contínua.",
                imagem = R.drawable.aula_evento
            ),
            Novidade(
                id = 10,
                titulo = "Curso de Cuidados Paliativos",
                descricao = "Realizado de 10 a 12/09/2024, às 18h, com abordagem humanizada voltada a pacientes em estágio terminal.",
                imagem = R.drawable.aula_evento
            )
        )
    }
}