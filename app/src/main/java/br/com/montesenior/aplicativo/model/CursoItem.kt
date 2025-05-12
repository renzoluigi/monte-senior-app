package br.com.montesenior.aplicativo.model

data class CursoItem(
    val titulo: String,
    val descricaoBreve: String,
    val projecao: String,
    val imagem: Int,
    val cargaHoraria: Int,
    val materialId: String
)
