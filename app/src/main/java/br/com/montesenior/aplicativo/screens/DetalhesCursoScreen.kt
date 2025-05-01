package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.model.CursoItem
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun DetalhesCursoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    curso: CursoItem
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                painter = painterResource(id = curso.imagem),
                contentDescription = "Imagem de um cuidador de idoso auxiliando uma idosa",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.Black.copy(alpha = 0.2f))
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = {
                        navController.navigate("cursos")
                    })
            ) {
                Text(
                    text = "< Voltar",
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo da empresa",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .scale(1.4f)
                        .offset(y = 15.dp)
                )
                Text(
                    curso.titulo,
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Faz a LazyColumn ocupar o espaço restante
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Detalhes do Curso",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(
                        text = "Carga horária:",
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "${curso.cargaHoraria} horas",
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = curso.descricaoBreve,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Projeto pedagógico",
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = curso.projecao,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Mais informações sobre o curso...",
                    modifier = Modifier
                        .padding(bottom = 8.dp)
                        .clickable(onClick = {}),
                    color = Color.Blue
                )
                Button(
                    modifier = Modifier.fillMaxWidth().height(50.dp),
                    onClick = {
                        navController.navigate("menu-curso-etarismo") //era pra ter matricula antes
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulMarinho,
                        contentColor = Color.White
                    )
                ) {
                    Text(
                        text = "Matricular-se",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Bold
                    )
                }
            }
        }
    }
}