package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
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
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.RowTextInfo
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior
import coil3.compose.AsyncImage

@Composable
fun PerfilScreen(usuario: Usuario) {

    Box(
        modifier = Modifier.fillMaxSize()
    ) {
        Image(
            painter = painterResource(id = R.drawable.banner_perfil_bg),
            contentDescription = null,
            modifier = Modifier
                .fillMaxWidth()
                .height(175.dp),
            contentScale = ContentScale.FillBounds
        )
        Column(
            modifier = Modifier.fillMaxWidth().verticalScroll(rememberScrollState()),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Spacer(modifier = Modifier.height(110.dp))
            Card(
                shape = CircleShape
            ) {
                AsyncImage(
                    model = usuario.imagem,
                    contentDescription = "Foto de perfil",
                    modifier = Modifier
                        .size(125.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.FillBounds
                )
            }
        }
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(top = 240.dp)
        ) {
            Text(
                text = usuario.nome,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 22.sp,
                fontWeight = FontWeight.Bold,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
            Text(
                text = usuario.tipo,
                modifier = Modifier.align(Alignment.CenterHorizontally),
                fontSize = 18.sp
            )
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .align(Alignment.CenterHorizontally)
                    .padding(16.dp)
            ) {
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    colors = ButtonDefaults.buttonColors(BlueMonteSenior)
                ) {
                    Text(
                        text = "Acessar trilha do cuidador  >",
                        fontSize = 16.sp
                    )
                }
                Spacer(modifier = Modifier.height(10.dp))
                Card(
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(240.dp),
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
                        RowTextInfo(info1 = "Gênero:", info2 = usuario.genero)
                        RowTextInfo(info1 = "Email:", info2 = usuario.email)
                        RowTextInfo(info1 = "Endereco:", info2 = usuario.endereco)
                        RowTextInfo(info1 = "Telefone:", info2 = formatarTelefone(usuario.telefone))
                        RowTextInfo(info1 = "Data de nascimento:", info2 = usuario.dataNascimento)
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
                                fontSize = 16.sp
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

fun formatarTelefone(telefone: String): String{
    return if (telefone.length == 11) { "(${telefone.substring(0, 2)}) ${telefone.substring(2, 7)}-${telefone.substring(7)}" } else { "" }
}