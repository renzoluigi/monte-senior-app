
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardCurso
import br.com.montesenior.aplicativo.components.VoltarColumnButton
import br.com.montesenior.aplicativo.model.CardCursoItem


@Composable
fun CursosScreen(modifier: Modifier = Modifier, navController: NavController) {
    val materiais = listOf(
        CardCursoItem(
            "Cuidador de idosos",
            "Ideal para familiares e profissionais, ensina cuidados básicos, segurança e bem-estar para idosos.",
            R.drawable.curso_cuidador,
            "detalhes-curso-cuidador"
        ),
        CardCursoItem(
            "Estereótipos e etarismo",
            "Desenvolva uma visão crítica sobre preconceitos contra a velhice," +
            " aprendendo a combater práticas discriminatórias e promover o respeito ao" +
            " envelhecimento.",
            R.drawable.curso_etarismo,
            "detalhes-curso-etarismo"
        )
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.white_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier = Modifier.fillMaxSize()) {
            VoltarColumnButton(navController = navController, rota = "boas-vindas")
            Column(modifier = Modifier.padding(horizontal = 16.dp)) {
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Text(
                        text = "Cursos disponíveis",
                        fontWeight = FontWeight.Bold,
                        fontSize = 26.sp
                    )
                }
                Spacer(modifier = Modifier.height(16.dp))
                LazyColumn(
                    modifier = Modifier
                        .fillMaxSize()
                ) {
                    items(materiais) { item ->
                        Spacer(modifier = Modifier.height(8.dp))
                        CardCurso(item, navController)
                        Spacer(modifier = Modifier.height(8.dp))
                    }
                }
            }
        }
    }
}
