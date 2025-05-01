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
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.RowTextInfo
import br.com.montesenior.aplicativo.model.Usuario
import br.com.montesenior.aplicativo.model.usuarioMock
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior

@Composable
fun PerfilScreen(usuario: Usuario) {
    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.perfil_cuidador_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(
            modifier = Modifier.fillMaxSize()
        ) {
            Spacer(modifier = Modifier.height(100.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
            }
            Card(
                shape = CircleShape,
                modifier = Modifier.align(Alignment.CenterHorizontally)
            ) {
                Image(
                    painter = painterResource(id = usuario.foto),
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                )
            }
            Spacer(modifier = Modifier.height(4.dp))
            Text(
                text = usuario.nome,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = "${usuario.endereco.cidade}, ${usuario.endereco.estado}",
                modifier = Modifier.align(Alignment.CenterHorizontally),
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(BlueMonteSenior)
                ) {
                    Text(
                        text = "Acessar trilha do cuidador  >",
                        fontSize = 16.sp
                    )
                }
                Column(
                    modifier = Modifier.fillMaxSize(),
                    verticalArrangement = Arrangement.Center
                ) {
                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(220.dp),
                        colors = CardDefaults.cardColors(
                            containerColor = AzulMarinho
                        )
                    ) {
                        Column(
                            modifier = Modifier
                                .fillMaxSize()
                                .padding(16.dp)
                        ) {
                            Text(
                                text = "Informações Pessoais",
                                fontSize = 20.sp,
                                fontWeight = FontWeight.Bold,
                                color = Color.White

                            )
                            Spacer(modifier = Modifier.height(10.dp))
                            RowTextInfo(info1 = "Nome:", info2 = usuario.nome)
                            RowTextInfo(info1 = "Email:", info2 = usuario.email)
                            RowTextInfo(info1 = "Telefone:", info2 = usuario.telefone)
                            RowTextInfo(info1 = "Data de nascimento:", info2 = usuario.nascimento)
                            RowTextInfo(
                                info1 = "Endereco:",
                                info2 = "${usuario.endereco.rua}," +
                                        " ${usuario.endereco.numero}," +
                                        " ${usuario.endereco.bairro}," +
                                        " ${usuario.endereco.cidade}," +
                                        " ${usuario.endereco.estado}"
                            )
                            Spacer(modifier = Modifier.height(5.dp))
                            Row(
                                modifier = Modifier
                                    .align(Alignment.End)
                                    .clickable(onClick = {})
                            ) {
                                Text(
                                    text = "Editar",
                                    color = Color.White,
                                    fontWeight = FontWeight.Bold,
                                    fontSize = 15.sp
                                )
                                Spacer(modifier = Modifier.width(5.dp))
                                Icon(
                                    imageVector = Icons.Default.Edit,
                                    contentDescription = "Editar",
                                    tint = Color.White,
                                    modifier = Modifier.size(22.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun SobreMimScreenPreview() {
    PerfilScreen(usuarioMock)
}