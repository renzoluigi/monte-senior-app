package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.NovidadeCard
import br.com.montesenior.aplicativo.repository.NovidadesRepository

@Composable
fun NovidadesScreen(modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.white_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        LazyColumn(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.spacedBy(8.dp)) {
            item {
                Spacer(Modifier.height(8.dp))
                Image(
                    painter = painterResource(id = R.drawable.news),
                    contentDescription = "Imagem de novidades",
                    modifier = Modifier.height(250.dp).fillMaxWidth(),
                    contentScale = ContentScale.Crop
                )
            }
            items(NovidadesRepository.novidades().size) { item ->
                NovidadeCard(
                    imagem = NovidadesRepository.novidades()[item].imagem,
                    titulo = NovidadesRepository.novidades()[item].titulo,
                    descricao = NovidadesRepository.novidades()[item].descricao
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NovidadesScreenPreview() {
    NovidadesScreen()
}