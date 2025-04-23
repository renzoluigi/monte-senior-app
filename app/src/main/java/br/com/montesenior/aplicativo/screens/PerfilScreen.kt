package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
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
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardPerfilStats
import br.com.montesenior.aplicativo.components.NavBar
import br.com.montesenior.aplicativo.components.RowTextInfo
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior

@Composable
fun PerfilScreen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Card(
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp),
            colors = CardDefaults.cardColors(BlueMonteSenior),
            shape = RoundedCornerShape(bottomEnd = 20.dp, bottomStart = 20.dp)
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
            verticalArrangement = Arrangement.Center
        ) {
            Image(
                painter = painterResource(id = R.drawable.foto),
                contentDescription = "imagem do cuidador",
                modifier = Modifier
                    .size(150.dp)
                    .clip(shape = CircleShape)
            )
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .offset(y = (-75).dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(10.dp))
            Text(
                text = "Sofia Marques Martins",
                fontSize = 20.sp,
                textAlign = TextAlign.Center,
                fontWeight = FontWeight.Bold
            )
            Spacer(modifier = Modifier.height(5.dp))
            Text(text = "Cidade Tiradentes, São Paulo", color = Color.Gray)
            Spacer(modifier = Modifier.height(50.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly
            ) {
                CardPerfilStats(
                    textUp = "Atendimentos",
                    textDown = "10"
                )
                CardPerfilStats(
                    textUp = "Trilha",
                    textDown = "30%"
                )
                CardPerfilStats(
                    textUp = "Marcados",
                    textDown = "2"
                )
            }
            Spacer(modifier = Modifier.height(20.dp))
            Card(
                modifier = Modifier
                    .height(210.dp)
                    .padding(horizontal = 20.dp),
                colors = CardDefaults.cardColors(Color.White),
                border = BorderStroke(width = 2.dp, color = BlueMonteSenior),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(170.dp)
                        .padding(start = 20.dp, end = 20.dp, top = 20.dp)
                ) {
                    RowTextInfo(info1 = "Nome:", info2 = "Sofia Marques")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Data de nascimento:", info2 = "30/10/2006")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Email:", info2 = "sosomarqs64@gmail.com")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Endereço:", info2 = "Cidade Tiradentes, São Paulo")
                    Spacer(modifier = Modifier.height(5.dp))
                    RowTextInfo(info1 = "Celular:", info2 = "(11) 95240-8932")
                }
                Column(modifier = Modifier.fillMaxWidth(), horizontalAlignment = Alignment.End) {
                    IconButton(onClick = {}) {
                        Icon(
                            imageVector = Icons.Filled.Edit,
                            contentDescription = "Botão de edição",
                            tint = Color.Gray
                        )
                    }
                }
            }
            Spacer(modifier = Modifier.height(20.dp))
            NavBar()
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SobreMimScreenPreview() {
    PerfilScreen()
}