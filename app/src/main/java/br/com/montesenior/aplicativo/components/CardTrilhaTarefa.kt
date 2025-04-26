package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.TrilhaItem
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun CardTrilhaTarefa(titulo: String, descricao: String, imagem: Int) {
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
                        fontFamily = Poppins,
                        fontWeight = FontWeight.Bold
                    )
                    Text(
                        descricao,
                        fontSize = 14.sp,
                        fontFamily = Poppins,
                        color = Color.Gray,
                        )
                }
                Button(
                    onClick = { /* TODO: ação */ },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(BlueMonteSenior)
                ) {
                    Text(
                        text = "Começar",
                        fontFamily = Poppins,
                        color = Color.White
                    )
                }
            }

            Spacer(modifier = Modifier.height(24.dp))
            Text(
                text = "Sua Trilha de Aprendizado",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 8.dp)
            ) {
                items(trilhaItens.size) { item ->
                    TrilhaCard(
                        imagem = trilhaItens[item].imagem,
                        titulo = trilhaItens[item].titulo,
                        onClick = { /* TODO: ação específica */ }
                    )
                }
            }
        }
    }
}

val trilhaItens = listOf(
    TrilhaItem(R.drawable.estudante, "Leia o Material"),
    TrilhaItem(R.drawable.prova, "Responda o Quiz"),
    TrilhaItem(R.drawable.logo, "Conclua a Atividade")
)

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CardTarefaSimplesPreview() {
    CardTrilhaTarefa(
        titulo = "Introdução",
        imagem = R.drawable.estudante,
        descricao = "Desenvolva as habilidades" +
                " essenciais que todo cuidador de idosos precisa para garantir o conforto, a segurança e o bem-estar " +
                "no dia a dia."
    )
}