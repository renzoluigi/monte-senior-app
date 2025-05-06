package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.Tarefa
import br.com.montesenior.aplicativo.model.TipoTarefa
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun CardTarefaTrilha(
    titulo: String,
    descricao: String,
    imagem: Int,
    navController: NavController
) {
    val trilhaItens = listOf(
        Tarefa(
            id = "",
            imagem = R.drawable.ler_material,
            titulo = "Leia o  Material",
            onClick = {
            },
            isConcluida = false,
            tipo = TipoTarefa.LEITURA
        ),
        Tarefa(
            id = "",
            imagem = R.drawable.assista_o_video,
            titulo = "Assista o Vídeo",
            onClick = {
                navController.navigate("video-aula")
            },
            isConcluida = false,
            tipo = TipoTarefa.VIDEO),
        Tarefa(
            id = "",
            imagem = R.drawable.prova,
            titulo = "Responda o Quiz",
            onClick = {
                navController.navigate("quiz")
            },
            isConcluida = false,
            tipo = TipoTarefa.QUIZ
        )
    )

    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = imagem),
                    contentDescription = "Ícone da $titulo",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.width(150.dp)) {
                    Text(
                        titulo,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        descricao,
                        fontSize = 14.sp,
                        color = Color.Gray,
                    )
                }
                Button(
                    onClick = { /* TODO: ação */ },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(AzulMarinho)
                ) {
                    Text(
                        text = "Começar",
                        color = Color.White
                    )
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Sua Trilha de Aprendizado",
                fontWeight = FontWeight.SemiBold
            )
            Spacer(modifier = Modifier.height(12.dp))
            LazyRow(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
            ) {
                items(trilhaItens.size) { item ->
                    Spacer(modifier = Modifier.width(8.dp))
                    TrilhaCard(
                        imagem = trilhaItens[item].imagem,
                        titulo = trilhaItens[item].titulo,
                        onClick = trilhaItens[item].onClick
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }
}
