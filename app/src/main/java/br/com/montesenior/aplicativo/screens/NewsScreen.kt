package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.NovidadeCard

@Composable
fun NovidadesScreen(modifier: Modifier = Modifier) {
    Box {
        Image(
            painter = painterResource(id = R.drawable.news_bg),
            contentDescription = null,
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.FillBounds
        )
        Column(modifier = Modifier
            .fillMaxSize()
            .padding(horizontal = 16.dp)) {

            Spacer(modifier = Modifier.height(8.dp))
            Image(
                painter = painterResource(id = R.drawable.news),
                contentDescription = "Imagem de novidades",
                modifier = Modifier.align(Alignment.CenterHorizontally).height(250.dp).fillMaxWidth(),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))
            NovidadeCard(
                imagem = R.drawable.curso_cuidador,
                titulo = "Evento AGETS",
                descricao = "O evento agets aconteceu no dia 23232323, as 23232, com a presenca do Dr Antonio Ferreira"
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun NovidadesScreenPreview() {
    NovidadesScreen()
}