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
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.CozyBlue
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun RegistroScreen(modifier: Modifier = Modifier) {
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.cute_blue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
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
                        fontSize = 28.sp,
                        fontFamily = Poppins
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Preencha os campos abaixo para continuar.",
                        fontFamily = Poppins,
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        OutlinedTextField(
                            onValueChange = {},
                            value = "",
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu nome completo", fontFamily = Poppins)
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Person,
                                    contentDescription = "Ícone de pessoa"
                                )
                            },
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {},
                            value = "",
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu email", fontFamily = Poppins)
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
                            onValueChange = {},
                            value = "",
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira sua senha")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Lock,
                                    contentDescription = "Ícone de senha"
                                )
                            },
                            visualTransformation = PasswordVisualTransformation(),
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {},
                            value = "",
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Confirme sua senha")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.Lock,
                                    contentDescription = "Ícone de senha"
                                )
                            },
                            visualTransformation = PasswordVisualTransformation(),
                            singleLine = true

                        )
                    }
                    Spacer(modifier = Modifier.height(15.dp))
                    Button(
                        onClick = {},
                        colors = ButtonDefaults.buttonColors(CozyBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        Text(
                            text = "Registrar-se",
                            fontSize = 20.sp,
                            fontFamily = Poppins
                        )
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun LoginScreenPreview() {
    RegistroScreen()
}