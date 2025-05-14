package br.com.montesenior.aplicativo.model

data class Curso(
    val titulo: String,
    val descricaoBreve: String,
    val projecao: String,
    val imagem: Int,
    val cargaHoraria: Int,
    val materialId: String,
    val maisInformacoesLink: String
)
