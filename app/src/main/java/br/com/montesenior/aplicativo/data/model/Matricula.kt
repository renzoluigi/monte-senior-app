package br.com.montesenior.aplicativo.data.model

import com.google.firebase.Timestamp

data class Matricula(
    val uid: String,
    val cursoId: String,
    val dataMatricula: Timestamp,
    val progresso: Int,
    val concluido: Boolean
)
