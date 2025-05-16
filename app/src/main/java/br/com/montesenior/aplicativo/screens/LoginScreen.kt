@file:JvmName("LoginScreenKt")

package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.VoltarColumnButton
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun LoginScreen(
    navController: NavController,
    loginScreenViewModel: LoginScreenViewModel = LoginScreenViewModel()
) {
    val email by loginScreenViewModel.email.observeAsState(initial = "")
    val senha by loginScreenViewModel.senha.observeAsState(initial = "")
    val mensagemErro by loginScreenViewModel.mensagemErro.observeAsState(initial = "")
    val isSenhaVisivel by loginScreenViewModel.isSenhaVisivel.observeAsState(initial = false)
    val isAutorizado by loginScreenViewModel.isAutorizado.observeAsState(initial = false)
    val isCarregando by loginScreenViewModel.isCarregando.observeAsState(initial = false)

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lightblue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        VoltarColumnButton(navController, "boas-vindas")
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
                        text = "Entrar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(4.dp))
                    Text(
                        text = "Insira seu email e senha para acessar o app.",
                        color = Color.Gray,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Email",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        onValueChange = {
                            loginScreenViewModel.onEmailChanged(it)
                        },
                        value = email,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text(
                                text = "Insira seu email"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
                        trailingIcon = {
                            Icon(
                                imageVector = Icons.Filled.Email,
                                contentDescription = "Email Icon"
                            )
                        },
                        singleLine = true
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Senha",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    OutlinedTextField(
                        onValueChange = {
                            loginScreenViewModel.onSenhaChanged(it)
                        },
                        value = senha,
                        modifier = Modifier.fillMaxWidth(),
                        shape = RoundedCornerShape(20.dp),
                        placeholder = {
                            Text(
                                text = "Insira sua senha"
                            )
                        },
                        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                        visualTransformation = if (isSenhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                        singleLine = true,
                        trailingIcon = {
                            IconButton(
                                onClick = {
                                    loginScreenViewModel.onToggleVisibilidadeSenha()
                                }
                            ) {
                                Icon(
                                    painter = painterResource(
                                        id = if (isSenhaVisivel) R.drawable.visibility_off else R.drawable.visibility_on
                                    ),
                                    contentDescription = "Visibility Icon"
                                )
                            }
                        }
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth(),
                        horizontalArrangement = Arrangement.End
                    ) {
                        Text(
                            text = "Esqueceu sua senha?",
                            color = Color.Black,
                            modifier = Modifier
                                .clickable(onClick = {
                                    navController.navigate("esqueceu-a-senha")
                                })
                        )
                    }
                    if (mensagemErro.isNotEmpty()) {
                        Text(
                            text = mensagemErro,
                            color = if (isAutorizado) Color.Green else Color.Red,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )

                    }
                    Spacer(modifier = Modifier.height(4.dp))
                    if (isCarregando) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(40.dp))
                        }
                    } else {
                        Button(
                            onClick = { loginScreenViewModel.onClickEntrar() },
                            colors = ButtonDefaults.buttonColors(AzulMarinho),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            shape = RoundedCornerShape(10.dp)
                        ) {
                            Text(
                                text = "Entrar",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
            LaunchedEffect(key1 = isAutorizado) {
                if (isAutorizado) {
                    navController.navigate("cursos") {
                        popUpTo("boas-vindas") {
                            inclusive = true
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun RegistroScreenPreview() {
    LoginScreen(
        loginScreenViewModel = LoginScreenViewModel(),
        navController = NavController(LocalContext.current)
    )
}