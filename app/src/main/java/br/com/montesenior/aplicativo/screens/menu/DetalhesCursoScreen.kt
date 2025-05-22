package br.com.montesenior.aplicativo.screens.menu

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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.abrirUrl
import br.com.montesenior.aplicativo.data.repository.SobreCursoRepository
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun DetalhesCursoScreen(
    navController: NavController,
    cursoId: String
) {
    val curso = SobreCursoRepository.cursos.getValue(cursoId)
    val contexto = LocalContext.current

    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                modifier = Modifier.fillMaxWidth().height(390.dp),
                painter = painterResource(id = curso.imagem),
                contentDescription = "Imagem de um cuidador de idoso auxiliando uma idosa",
                contentScale = ContentScale.FillBounds
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
            LazyColumn(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 16.dp, end = 16.dp, top = 400.dp)
            ) {
                item {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 8.dp),
                        verticalAlignment = Alignment.CenterVertically
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
                        textAlign = TextAlign.Justify,
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
                        textAlign = TextAlign.Justify,
                        modifier = Modifier.padding(bottom = 4.dp)
                    )
                    Text(
                        text = "Mais informações sobre o curso...",
                        modifier = Modifier
                            .padding(bottom = 8.dp)
                            .clickable(onClick = {
                                abrirUrl(contexto = contexto, url = curso.maisInformacoesLink)
                            }),
                        color = Color.Blue
                    )
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        onClick = {
                            navController.navigate("cursos/${curso.cursoId}")
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
                    Spacer(modifier = Modifier.height(8.dp))
                }
            }
        }
    }
}
