package br.com.montesenior.aplicativo.screens.menu

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.NovidadeCard
import br.com.montesenior.aplicativo.data.repository.NovidadesRepository

@Composable
fun NovidadesScreen(navController: NavController) {
    BackHandler {
        navController.navigate("cursos") {
            popUpTo(navController.graph.startDestinationId) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    Box {
        Image(
            painter = painterResource(id = R.drawable.white_bg),
            contentDescription = "Fundo branco",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally) {
            item {
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.news),
                    contentDescription = "Imagem de novidades",
                    modifier = Modifier.height(250.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            items(NovidadesRepository.novidades().size) { index ->
                Spacer(modifier = Modifier.height(8.dp))
                NovidadeCard(
                    imagem = NovidadesRepository.novidades()[index].imagem,
                    titulo = NovidadesRepository.novidades()[index].titulo,
                    descricao = NovidadesRepository.novidades()[index].descricao,
                    link = NovidadesRepository.novidades()[index].link
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}