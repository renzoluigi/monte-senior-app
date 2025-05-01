package br.com.montesenior.aplicativo.model

data class EnderecoItem(
    val rua: String,
    val numero: String,
    val bairro: String,
    val cidade: String,
    val estado: String,
)

val enderecoMock = EnderecoItem(
    rua = "Rua das Flores",
    numero = "123",
    bairro = "Centro",
    cidade = "São Paulo",
    estado = "SP"
)