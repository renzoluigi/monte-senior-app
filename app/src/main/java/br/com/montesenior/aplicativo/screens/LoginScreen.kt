@file:JvmName("LoginScreenKt")

package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
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
import br.com.montesenior.aplicativo.ui.theme.CozyBlue
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun LoginScreen(
    navController: NavController,
    modifier: Modifier = Modifier,
    loginScreenViewModel: LoginScreenViewModel
) {
    val email by loginScreenViewModel.email.observeAsState(initial = "")
    val senha by loginScreenViewModel.senha.observeAsState(initial = "")
    val mensagemErro by loginScreenViewModel.mensagemErro.observeAsState(initial = "")
    val isSenhaVisivel by loginScreenViewModel.isSenhaVisivel.observeAsState(initial = false)
    val isAutorizado by loginScreenViewModel.isAutorizado.observeAsState(initial = false)

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
                        text = "Entrar",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp,
                        fontFamily = Poppins
                    )
                    Spacer(modifier = Modifier.height(5.dp))
                    Text(
                        text = "Insira seu email e senha para acessar o app.",
                        color = Color.Gray,
                        fontFamily = Poppins,
                        fontSize = 18.sp
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Text(
                        text = "Email",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins
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
                                text = "Insira seu email",
                                fontFamily = Poppins
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
                        fontWeight = FontWeight.Bold,
                        fontFamily = Poppins
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
                                text = "Insira sua senha",
                                fontFamily = Poppins
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
                                    painter = painterResource(id = if (isSenhaVisivel) R.drawable.visibility_off else R.drawable.visibility_on),
                                    contentDescription = "Visibility Icon"
                                )
                            }
                        }
                    )
                    TextButton(
                        onClick = {
                            navController.navigate("esqueceuasenha")
                        }
                    ) {
                        Text(
                            text = "Esqueceu sua senha?",
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.End,
                            color = Color.Black,
                            fontFamily = Poppins
                        )
                    }
                    Text(
                        text = mensagemErro,
                        color = if (isAutorizado) Color.Green else Color.Red,
                        fontFamily = Poppins,
                        modifier = Modifier
                            .fillMaxWidth()
                            .offset(y = (-10).dp),
                        textAlign = TextAlign.Center
                    )
                    Button(
                        onClick = {
                            loginScreenViewModel.onClickEntrar()
                            if (isAutorizado) {
                                navController.navigate("cursos")
                            }
                        },
                        colors = ButtonDefaults.buttonColors(CozyBlue),
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(60.dp)
                    ) {
                        Text(
                            text = "Entrar",
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
private fun RegistroScreenPreview() {
    LoginScreen(modifier = Modifier, loginScreenViewModel = LoginScreenViewModel(), navController = NavController(LocalContext.current))
}