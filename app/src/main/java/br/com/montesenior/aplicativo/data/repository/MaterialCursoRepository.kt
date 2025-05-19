package br.com.montesenior.aplicativo.data.repository

import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.data.model.MaterialCurso
import br.com.montesenior.aplicativo.data.model.Modulo
import br.com.montesenior.aplicativo.data.model.Tarefa
import br.com.montesenior.aplicativo.data.model.TipoTarefa

object MaterialCursoRepository {
    val materialCursos = mapOf(
        "curso_cuidador" to MaterialCurso(
            modulos = listOf(
                Modulo(
                    id = "intro",
                    titulo = "Introdução",
                    descricao = "Uma visão geral dos principais tópicos" +
                            " que abordaremos para te ajudar no dia a dia do cuidado.",
                    imagem = R.drawable.didatic,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_leitura_conteudo",
                            tipo = TipoTarefa.LEITURA,
                            titulo = "Leia o  Material",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "intro_etarismo_video_aula",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Vídeo Introdutório",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "intro_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Quiz Introdutório",
                            isConcluida = false
                        )
                    )
                ),
                Modulo(
                    id = "habilidades",
                    titulo = "Habilidades Básicas de Cuidado",
                    descricao = "Desenvolva as habilidades" +
                            " essenciais que todo cuidador de idosos" +
                            " precisa para garantir o conforto, a segurança e o bem-estar " +
                            "no dia a dia.",
                    imagem = R.drawable.habilidade,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_video",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Assistir ao Vídeo",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "inclusao_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Responder o Quiz",
                            isConcluida = false
                        )
                    )
                )
            )
        ),
        "curso_etarismo" to MaterialCurso(
            modulos = listOf(
                Modulo(
                    id = "intro",
                    titulo = "Introdução",
                    descricao = "Uma visão geral dos principais tópicos" +
                            " que abordaremos para te ajudar no dia a dia do cuidado.",
                    imagem = R.drawable.didatic,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_material",
                            tipo = TipoTarefa.LEITURA,
                            titulo = "Leia o  Material",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "intro_etarismo_video_aula",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Vídeo Introdutório",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "intro_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Quiz Introdutório",
                            isConcluida = false
                        )
                    )
                ),
                Modulo(
                    id = "habilidades",
                    titulo = "Habilidades Básicas de Cuidado",
                    descricao = "Desenvolva as habilidades" +
                            " essenciais que todo cuidador de idosos" +
                            " precisa para garantir o conforto, a segurança e o bem-estar " +
                            "no dia a dia.",
                    imagem = R.drawable.habilidade,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_video",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Assistir ao Vídeo",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "inclusao_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Responder o Quiz",
                            isConcluida = true
                        )
                    )
                ),
                Modulo(
                    id = "habilidades",
                    titulo = "Habilidades Básicas de Cuidado",
                    descricao = "Desenvolva as habilidades" +
                            " essenciais que todo cuidador de idosos" +
                            " precisa para garantir o conforto, a segurança e o bem-estar " +
                            "no dia a dia.",
                    imagem = R.drawable.habilidade,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_video",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Assistir ao Vídeo",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "inclusao_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Responder o Quiz",
                            isConcluida = false
                        )
                    )
                ),
                Modulo(
                    id = "habilidades",
                    titulo = "Habilidades Básicas de Cuidado",
                    descricao = "Desenvolva as habilidades" +
                            " essenciais que todo cuidador de idosos" +
                            " precisa para garantir o conforto, a segurança e o bem-estar " +
                            "no dia a dia.",
                    imagem = R.drawable.habilidade,
                    tarefas = listOf(
                        Tarefa(
                            id = "intro_video",
                            tipo = TipoTarefa.VIDEO,
                            titulo = "Assistir ao Vídeo",
                            isConcluida = false
                        ),
                        Tarefa(
                            id = "inclusao_etarismo_quiz",
                            tipo = TipoTarefa.QUIZ,
                            titulo = "Responder o Quiz",
                            isConcluida = false
                        )
                    )
                )
            )
        )
    )
}