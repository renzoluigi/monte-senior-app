package br.com.montesenior.aplicativo.model

import com.google.firebase.Timestamp

data class Matricula(
    val uid: String,
    val cursoId: String,
    val dataMatricula: Timestamp,
    val progresso: Int,
    val concluido: Boolean
)
