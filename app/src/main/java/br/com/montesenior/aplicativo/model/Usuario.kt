package br.com.montesenior.aplicativo.model

import br.com.montesenior.aplicativo.R

data class Usuario(
    val id: Long,
    val nome: String,
    val email: String,
    val endereco: EnderecoItem,
    val telefone: String,
    val senha: String,
    val progresso: Int,
    val foto: Int,
    val nascimento: String
)

val usuarioMock = Usuario(
    id = 1,
    nome = "Marconi Luckas",
    email = "email@gmail.com",
    endereco = enderecoMock,
    telefone = "(11) 99999-9999",
    senha = "admin",
    progresso = 0,
    foto = R.drawable.foto,
    nascimento = "23/05/2025"
)
