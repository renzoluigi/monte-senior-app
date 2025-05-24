package br.com.montesenior.aplicativo.screens.authentication

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocationOn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.DatePicker
import br.com.montesenior.aplicativo.components.TipoAlunoField
import br.com.montesenior.aplicativo.components.VoltarColumnButton
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun CompletarRegistroScreen(
    nome: String,
    email: String,
    telefone: String,
    genero: String,
    imagemUrl: String,
    navController: NavController
) {
    val completarRegistroScreenViewModel: CompletarRegistroScreenViewModel = viewModel()
    val tipo by completarRegistroScreenViewModel.tipo.observeAsState("")
    val endereco by completarRegistroScreenViewModel.endereco.observeAsState("")
    val senha by completarRegistroScreenViewModel.senha.observeAsState("")
    val dataNascimento by completarRegistroScreenViewModel.dataNascimento.observeAsState("")
    val confirmarSenha by completarRegistroScreenViewModel.confirmarSenha.observeAsState("")
    val isSenhaVisivel by completarRegistroScreenViewModel.isSenhaVisivel.observeAsState(false)
    val isConfirmarSenhaVisivel by completarRegistroScreenViewModel.isConfirmarSenhaVisivel.observeAsState(false)
    val isCarregando by completarRegistroScreenViewModel.isCarregando.observeAsState(false)
    val mensagemErro by completarRegistroScreenViewModel.mensagemErro.observeAsState("")
    val isErro by completarRegistroScreenViewModel.isErro.observeAsState(false)


    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lightblue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        VoltarColumnButton(
            onClick = { navController.popBackStack() }
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
                        text = "Completar registro",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        DatePicker(
                            label = "Data de Nascimento",
                            selectedDate = dataNascimento,
                            onDateSelected = {
                                completarRegistroScreenViewModel.onDataNascimentoChanged(it)
                            }
                        )
                        TipoAlunoField(
                            tipoSelecionado = tipo,
                            onTipoChanged = { completarRegistroScreenViewModel.onTipoChanged(it) })
                        OutlinedTextField(
                            onValueChange = {
                                completarRegistroScreenViewModel.onEnderecoChanged(it)
                            },
                            value = endereco,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira seu endereço")
                            },
                            trailingIcon = {
                                Icon(
                                    imageVector = Icons.Filled.LocationOn,
                                    contentDescription = null
                                )
                            },
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {
                                completarRegistroScreenViewModel.onSenhaChanged(it)
                            },
                            value = senha,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Insira sua senha")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(
                                        id = if (isSenhaVisivel) {
                                            R.drawable.visibility_on
                                        } else {
                                            R.drawable.visibility_off
                                        }
                                    ),
                                    contentDescription = "Ícone de senha",
                                    modifier = Modifier.clickable(
                                        onClick = {
                                            completarRegistroScreenViewModel.onToggleVisibilidadeSenha()
                                        }
                                    )
                                )
                            },
                            visualTransformation = if (isSenhaVisivel) VisualTransformation.None else PasswordVisualTransformation(),
                            singleLine = true
                        )
                        OutlinedTextField(
                            onValueChange = {
                                completarRegistroScreenViewModel.onConfirmarSenhaChanged(it)
                            },
                            value = confirmarSenha,
                            modifier = Modifier.fillMaxWidth(),
                            shape = RoundedCornerShape(20.dp),
                            label = {
                                Text(text = "Confirme sua senha")
                            },
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
                            trailingIcon = {
                                Icon(
                                    painter = painterResource(
                                        id =
                                            if (isConfirmarSenhaVisivel) {
                                                R.drawable.visibility_on
                                            } else {
                                                R.drawable.visibility_off
                                            }
                                    ),
                                    contentDescription = "Ícone de senha",
                                    modifier = Modifier.clickable(
                                        onClick = {
                                            completarRegistroScreenViewModel.onToggleVisibilidadeConfirmarSenha()
                                        }
                                    )
                                )
                            },
                            visualTransformation = if (isConfirmarSenhaVisivel)
                                VisualTransformation.None else PasswordVisualTransformation(),
                            singleLine = true
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (mensagemErro.isNotEmpty()) {
                        Text(
                            text = mensagemErro,
                            color = if (isErro) Color.Red else Color.Green,
                            modifier = Modifier.fillMaxWidth(),
                            textAlign = TextAlign.Center
                        )
                    }
                    Spacer(modifier = Modifier.height(8.dp))
                    if (isCarregando) {
                        Box(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 8.dp),
                            contentAlignment = Alignment.Center
                        ) {
                            CircularProgressIndicator(modifier = Modifier.size(36.dp))
                        }
                    } else {
                        Button(
                            onClick = {
                                completarRegistroScreenViewModel.onClickConcluir(
                                    nome = nome,
                                    email = email,
                                    genero = genero,
                                    telefone = telefone,
                                    imagemUrl = imagemUrl
                                )
                            },
                            colors = ButtonDefaults.buttonColors(AzulMarinho),
                            modifier = Modifier
                                .fillMaxWidth()
                                .height(60.dp),
                            shape = RoundedCornerShape(10.dp),
                            enabled = true
                        ) {
                            Text(
                                text = "Concluir",
                                fontSize = 20.sp
                            )
                        }
                    }
                }
            }
        }
    }
}