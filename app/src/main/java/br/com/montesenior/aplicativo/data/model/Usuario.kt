package br.com.montesenior.aplicativo.data.model

import com.google.firebase.firestore.PropertyName

data class Usuario(
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val tipo: String = "aluno",
    val imagem: String,
    @get:PropertyName("data_nascimento") @set:PropertyName("data_nascimento")
    var dataNascimento: String,
    val genero: String,
    val matriculas: List<String> = listOf()
) {
    constructor() : this("", "", "", "", "", "", "", "", listOf())
}
