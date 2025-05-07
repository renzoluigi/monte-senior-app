package br.com.montesenior.aplicativo.screens


import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.TopBarVideoAula
import br.com.montesenior.aplicativo.components.YoutubePlayer
import br.com.montesenior.aplicativo.model.VideoAula
import br.com.montesenior.aplicativo.repository.VideoAulaRepository
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun VideoAulaScreen(
    viewModel: VideoAulaScreenViewModel = VideoAulaScreenViewModel(),
    navController: NavController,
    videoAulaId: String
) {
    val isAssistido by viewModel.isAssistido.observeAsState(false)
    val videoAula = VideoAulaRepository.videoAulas().getValue(videoAulaId)

    Scaffold(
        topBar = {
            TopBarVideoAula(
                tipo = "Videoaula",
                tituloAula = "Introdução",
                navController = navController
            )
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
                .padding(innerPadding)
        ) {
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(240.dp)
            ) {
                YoutubePlayer(
                    videoId = videoAula.youtubeId,
                    onVideoEnded = {
                        viewModel.onVideoEnded()
                    }
                )
            }
            Column(
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 8.dp)
            ) {
                Text(
                    text = videoAula.tituloAula,
                    fontSize = 24.sp,
                    fontWeight = FontWeight.Bold,
                    color = AzulMarinho,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Descrição da Aula:",
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp
                )
                Text(
                    text = videoAula.descricaoAula,
                    modifier = Modifier.padding(vertical = 4.dp)
                )
                Surface(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp),
                    shape = MaterialTheme.shapes.medium,
                    color = AzulMarinho.copy(alpha = 0.1f)
                ) {
                    Column(
                        modifier = Modifier.padding(16.dp)
                    ) {
                        Text(
                            text = "≡ƒôü Materiais Complementares",
                            fontWeight = FontWeight.SemiBold,
                            color = AzulMarinho
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "ΓÇó Apresenta├º├úo em PDF",
                            modifier = Modifier.clickable(onClick = {}),
                            color = Color.DarkGray
                        )
                        Text(
                            text = "ΓÇó Lista de Exercícios",
                            modifier = Modifier.clickable(onClick = {}),
                            color = Color.DarkGray
                        )
                        Text(
                            text = "ΓÇó Links Úteis",
                            modifier = Modifier.clickable(onClick = {}),
                            color = Color.DarkGray
                        )
                    }
                }
                Spacer(modifier = Modifier.height(8.dp))
                Button(
                    onClick = {},
                    modifier = Modifier
                        .fillMaxWidth()
                        .height(50.dp),
                    shape = RoundedCornerShape(10.dp),
                    enabled = isAssistido,
                    colors = ButtonDefaults.buttonColors(
                        containerColor = AzulMarinho,
                        disabledContainerColor = AzulMarinho.copy(alpha = 0.5f)
                    )
                ) {
                    Text(
                        text = "Concluir aula",
                        fontFamily = Poppins
                    )
                }
            }
        }

    }
}
