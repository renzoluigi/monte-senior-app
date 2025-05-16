package br.com.montesenior.aplicativo.model

import com.google.firebase.firestore.FirebaseFirestore

data class Usuario(
    val uid: String,
    val nome: String,
    val email: String,
    val endereco: String,
    val telefone: String,
    val tipo: String = "aluno",
    val imagem: String,
    val dataNascimento: String,
    val matriculas: List<String> = listOf()
) {
    constructor(): this("", "", "", "", "", "", "", "", listOf())
}
