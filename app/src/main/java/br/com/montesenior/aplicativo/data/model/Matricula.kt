package br.com.montesenior.aplicativo.data.model

import com.google.firebase.Timestamp
import com.google.firebase.firestore.PropertyName

data class Matricula(
    val cursoId: String,
    @get:PropertyName("data_matricula") @set:PropertyName("data_matricula")
    var dataMatricula: Timestamp,
    val progresso: Int,
    val concluido: Boolean
)
