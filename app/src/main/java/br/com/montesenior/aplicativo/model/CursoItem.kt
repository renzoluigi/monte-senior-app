package br.com.montesenior.aplicativo.model

data class CursoItem(
    val id: Int,
    val titulo: String,
    val descricaoBreve: String,
    val projecao: String,
    val imagem: Int,
    val cargaHoraria: Int,
)
