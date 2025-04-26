
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardMaterial
import br.com.montesenior.aplicativo.ui.theme.CozyBlue
import br.com.montesenior.aplicativo.ui.theme.Poppins


data class MaterialItem(
    val titulo: String,
    val descricao: String,
    val imagem: Int
)

@Composable
fun MaterialScreen(modifier: Modifier = Modifier, navController: NavController) {
    val materiais = listOf(
        MaterialItem(
            "Cuidador de idosos",
            "Aqui, você encontrará informações e orientações essenciais para apoiar idosos com dificuldades alimentares.",
            R.drawable.curso_cuidador_img
        ),
        MaterialItem(
            "Bem-estar e higiene pessoal do idoso",
            "Aprenda a auxiliar em rotinas, adaptar cuidados e promover conforto físico e emocional.",
            R.drawable.higiene
        ),
        MaterialItem("Título 3", "Descrição breve do conteúdo 3", R.drawable.ultimo),
    )
    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lightblue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        Column(modifier.padding(16.dp)) {
            Column(modifier = Modifier.clickable(onClick = {

            })) {
                Text(
                    text = "< Voltar",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 20.sp,
                    color = CozyBlue
                )
            }
            Spacer(modifier = Modifier.height(15.dp))
            Column(
                modifier = Modifier.fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    text = "Cursos disponíveis",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 26.sp,
                    color = CozyBlue
                )
            }
            Spacer(modifier = Modifier.height(16.dp))
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                items(materiais) { item ->
                    CardMaterial(item, navController)
                }
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun MaterialScreenPreview() {
    MaterialScreen(navController = NavController(LocalContext.current))
}