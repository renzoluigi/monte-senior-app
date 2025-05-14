package br.com.montesenior.aplicativo.model

data class VideoAula (
    val youtubeId: String,
    val tituloAula: String,
    val descricaoAula: String,
    val isAssistido: Boolean,
    val pdfLink: String,
    val exerciosLink: String,
    val linksUteis: String
)