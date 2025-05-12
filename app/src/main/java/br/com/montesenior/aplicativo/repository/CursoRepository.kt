package br.com.montesenior.aplicativo.repository

import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.CursoItem

object CursoRepository {
    val cursos = mapOf(
        "curso_cuidador" to CursoItem(
            titulo = "Curso de cuidador de idosos",
            descricaoBreve = "Este curso abrangente oferece uma formação completa para cuidadores de idosos.",
            projecao = "A profissão e as responsabilidades do Cuidador de pessoa Idosa. (25 H)\n" +
                    "O processo de envelhecimento da pessoa idosa e os principais cuidados de higiene e conforto, saúde e alimentação. (25H)\n" +
                    "Auxílio na reabilitação da pessoa idosa acometida por imobilidade prejudicada, incontinências e adaptações pós sequelas. (20 H)\n" +
                    "Marketing Pessoal, elaboração do currículo. auxílio no desenvolvimento profissional. (10H)",
            imagem = R.drawable.curso_cuidador_bg,
            cargaHoraria = 80,
            materialId = "curso_cuidador"
        ),
        "curso_etarismo" to CursoItem(
            titulo = "Curso de estereótipos e etarismo",
            descricaoBreve = "Este curso oferece uma reflexão profunda sobre os estereótipos e o etarismo" +
                    " (discriminação por idade), capacitando os participantes a identificar e combater" +
                    " práticas prejudiciais contra idosos.",
            projecao = "Introdução ao conceito de etarismo, como ele se manifesta no cotidiano e seus impactos na saúde mental e física dos idosos.\n" +
                    "Como promover uma cultura de respeito e inclusão em diferentes contextos (família, trabalho, saúde e sociedade).\n" +
                    "Análise de situações comuns e alternativas para abordá-las com empatia.\n" +
                    "Dinâmicas e recursos para sensibilizar outras pessoas sobre o tema.",
            imagem = R.drawable.curso_estereotipos_bg,
            cargaHoraria = 2,
            materialId = "curso_etarismo"
        )
    )
}
