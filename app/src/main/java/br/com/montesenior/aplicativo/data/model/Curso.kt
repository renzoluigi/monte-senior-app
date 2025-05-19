package br.com.montesenior.aplicativo.data.model

data class Curso(
    val titulo: String,
    val descricaoBreve: String,
    val projecao: String,
    val imagem: Int,
    val cargaHoraria: Int,
    val cursoId: String,
    val maisInformacoesLink: String
)
