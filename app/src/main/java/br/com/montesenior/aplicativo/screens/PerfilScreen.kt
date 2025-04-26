package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardPerfilStats
import br.com.montesenior.aplicativo.components.RowTextInfo
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun PerfilScreen(modifier: Modifier = Modifier) {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(BlueMonteSenior),
            shape = RectangleShape
        ) {
            Image(
                modifier = Modifier.fillMaxSize(),
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Banner Monte Senior",
            )
        }
        Column(
            modifier = Modifier
                .fillMaxWidth()
                .height(150.dp)
                .offset(y = (-75).dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
        ) {
            Card(shape = CircleShape, elevation = CardDefaults.cardElevation(10.dp)) {
                Image(
                    painter = painterResource(id = R.drawable.foto),
                    contentDescription = "imagem do cuidador",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(shape = CircleShape)
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-75).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Marconi Luckas",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(
                text = "São Paulo, SP",
                color = Color.Gray,
                fontFamily = Poppins,
                fontSize = 15.sp
            )
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp)
                    .offset(y = (-20).dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CardPerfilStats(
                    textUp = "Cursos",
                    textDown = "2"
                )
                CardPerfilStats(
                    textUp = "Finalizados",
                    textDown = "2"
                )
                CardPerfilStats(
                    textUp = "Progresso",
                    textDown = "30%"
                )
            }
            Spacer(modifier = Modifier.height(30.dp))
            Card(
                modifier = Modifier
                    .height(240.dp)
                    .offset(y = (-20).dp)
                    .padding(horizontal = 20.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 2.dp, color = BlueMonteSenior),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(195.dp)
                        .padding(start = 10.dp, end = 10.dp, top = 10.dp)
                ) {
                    Row {
                        Text(
                            text = "Dados pessoais",
                            fontWeight = FontWeight.Bold,
                            fontFamily = Poppins,
                            fontSize = 20.sp
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .clickable(onClick = { }),
                            horizontalArrangement = Arrangement.End
                        ) {
                            Text(
                                "Editar",
                                color = Color.Gray,
                                fontFamily = Poppins
                            )
                            Spacer(modifier = Modifier.width(5.dp))
                            Icon(
                                imageVector = Icons.Filled.Edit,
                                contentDescription = "Botão de edição",
                                tint = Color.Gray,
                                modifier = Modifier.size(22.dp)
                            )
                        }
                    }
                    Spacer(modifier = Modifier.height(10.dp))
                    RowTextInfo(info1 = "Nome:", info2 = "Marconi Luckas")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Data de nascimento:", info2 = "23/04/2025")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Email:", info2 = "email@gmail.com")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Endereço:", info2 = "Rua 123, São Paulo, SP")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Celular:", info2 = "(11) 91111-1111")
                }
                Spacer(modifier = Modifier.height(15.dp))
//                Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.End) {
//                    Row(
//                        modifier = Modifier
//                            .padding(horizontal = 10.dp)
//                            .clickable {},
//                        horizontalArrangement = Arrangement.End
//                    ) {
//
//                    }
//                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SobreMimScreenPreview() {
    PerfilScreen()
}