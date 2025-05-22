package com.br.montesenior.aplicativo_porto.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.GeneroField
import br.com.montesenior.aplicativo.components.VoltarColumnButton
import br.com.montesenior.aplicativo.screens.authentication.RegistroScreenViewModel
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun RegistroScreen(navController: NavController) {
    val registroScreenViewModel: RegistroScreenViewModel = viewModel()
    val nome by registroScreenViewModel.nome.observeAsState("")
    val email by registroScreenViewModel.email.observeAsState("")
    val genero by registroScreenViewModel.genero.observeAsState("")
    val telefone by registroScreenViewModel.telefone.observeAsState("")
    val isRegistroSucesso by registroScreenViewModel.isRegistroSucesso.observeAsState()
    val mensagemErro by registroScreenViewModel.mensagemErro.observeAsState()

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lightblue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        VoltarColumnButton(
            onClick = { navController.navigate("boas-vindas") }
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Registre-se",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Preencha os campos abaixo para continuar.",
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            onValueChange = {
                                registroScreenViewModel.onNomeChanged(it)
                            },
                            value = nome,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu nome completo")
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Ícone de pessoa"
                                )
                            },
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {
                                registroScreenViewModel.onEmailChanged(it)
                            },
                            value = email,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu email")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Email,
                                    contentDescription = "Ícone de e-mail"
                                )
                            },
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {
                                registroScreenViewModel.onTelefoneChanged(it)
                            },
                            value = telefone,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu telefone")
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Phone,
                                    contentDescription = "Ícone de telefone"
                                )
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Phone)
                        )
                        GeneroField(
                            generoSelecionado = genero,
                            onGeneroChanged = { registroScreenViewModel.onGeneroChanged(it) })
                    }
                    Spacer(modifier = Modifier.height(16.dp))
                    Button(
                        onClick = {
                            navController.navigate("enviar-imagem/$nome/$email/$telefone/$genero")
                        },
                        colors = ButtonDefaults.buttonColors(AzulMarinho),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp),
                        shape = RoundedCornerShape(10.dp),
                        enabled = true
                    ) {
                        Text(
                            text = "Continuar",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

