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
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.model.CursoItem
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun DetalhesCursoScreen(
    modifier: Modifier = Modifier,
    navController: NavController,
    curso: CursoItem
) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                modifier = Modifier
                    .fillMaxSize(),
                painter = painterResource(id = curso.imagem),
                contentDescription = "Imagem de um cuidador de idoso auxiliando uma idosa",
                contentScale = ContentScale.Crop
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
            Spacer(modifier = Modifier.height(400.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 350.dp)
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
}