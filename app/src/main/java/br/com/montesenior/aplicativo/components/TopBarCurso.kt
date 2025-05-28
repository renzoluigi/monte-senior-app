package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import coil3.compose.AsyncImage

@Composable
fun TopBarCurso(
    nomeCurso: String,
    usuario: Usuario,
    progresso: Int,
    comandoVoltar: () -> Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .background(AzulMarinho)
            .padding(8.dp)
    ) {
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier.fillMaxWidth()
        ) {
            Column {
                Icon(
                    imageVector = Icons.AutoMirrored.Filled.ArrowBack,
                    contentDescription = "Voltar",
                    tint = Color.White,
                    modifier = Modifier
                        .size(30.dp)
                        .clickable(onClick = comandoVoltar)
                )
            }
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.End
            ) {
                Column(Modifier.padding(start = 8.dp)) {
                    Text(
                        text = formatarNome(usuario.nome),
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = nomeCurso,
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = "Progresso: $progresso%",
                        fontSize = 14.sp,
                        color = Color.White,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
                Spacer(modifier = Modifier.width(12.dp))
                AsyncImage(
                    model = usuario.imagem,
                    contentDescription = "Foto do usuário",
                    modifier = Modifier
                        .size(60.dp)
                        .clip(CircleShape),
                    contentScale = ContentScale.Crop
                )
            }
        }
    }
}

fun formatarNome(nome: String): String {
    val nomes = nome.split(" ")
    return if (nomes.size > 1) "${nomes[0]} ${nomes[1]}" else nome
}