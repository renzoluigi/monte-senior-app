package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.TopBarLeitura
import br.com.montesenior.aplicativo.data.repository.LeituraConteudoRepository

@Composable
fun LeituraConteudoScreen(
    materialId: String,
    navController: NavController
) {
    val conteudos = LeituraConteudoRepository.conteudos.getValue(materialId).conteudos
    val pagerState = rememberPagerState(
        initialPage = 0,
        pageCount = { conteudos.size }
    )

    HorizontalPager(
        state = pagerState,
        modifier = Modifier.fillMaxSize()
    ) { page ->
        Box(modifier = Modifier.fillMaxSize()) {
            Image(
                painter = painterResource(id = conteudos[page].second),
                contentDescription = null,
                contentScale = ContentScale.Crop,
                modifier = Modifier.fillMaxSize()
            )
            TopBarLeitura(
                pagina = pagerState.currentPage + 1,
                totalPag = pagerState.pageCount,
                navController = navController
            )
            Box(
                modifier = Modifier
                    .align(Alignment.BottomCenter)
                    .background(Color.Black.copy(alpha = 0.5f))
                    .fillMaxWidth()
                    .padding(16.dp)
            ) {
                Text(
                    text = conteudos[page].first,
                    color = Color.White,
                    textAlign = TextAlign.Justify,
                    fontSize = 18.sp
                )
            }
        }
    }
}
