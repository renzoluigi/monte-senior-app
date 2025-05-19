package br.com.montesenior.aplicativo.data.repository

import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.data.model.LeituraConteudo

object LeituraConteudoRepository {
    val conteudos = mapOf(
        "intro_leitura_conteudo" to LeituraConteudo (
             listOf(
                Pair("aaaa", R.drawable.curso_estereotipos_bg),
                Pair("bbbb", R.drawable.curso_etarismo),
                Pair("cccc", R.drawable.curso_cuidador)
            )
        )
    )
}