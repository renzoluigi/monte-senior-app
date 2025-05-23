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
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.data.model.Tarefa

@Composable
fun CardModulo(
    titulo: String,
    descricao: String,
    imagem: Int,
    navController: NavController,
    tarefas: List<Tarefa>
) {
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
                    modifier = Modifier.size(64.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.fillMaxWidth()) {
                    Text(
                        text = titulo,
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold,
                        textAlign = TextAlign.End,
                        modifier = Modifier.align(Alignment.End)
                    )
                    Text(
                        text = descricao,
                        fontSize = 14.sp,
                        color = Color.Gray,
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.align(Alignment.End)
                    )
                }
            }
            Spacer(modifier = Modifier.height(8.dp))
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
                items(tarefas.size) { item ->
                    Spacer(modifier = Modifier.width(8.dp))
                    CardTarefa(
                        imagem = tarefas[item].tipo.imagem,
                        titulo = tarefas[item].titulo,
                        onClick = {
                            navController.navigate("${tarefas[item].tipo.id}/${tarefas[item].id}")
                        }
                    )
                    Spacer(modifier = Modifier.width(4.dp))
                }
            }
        }
    }
}