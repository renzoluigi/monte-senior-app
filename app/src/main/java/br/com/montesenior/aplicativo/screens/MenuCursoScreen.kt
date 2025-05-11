package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.CardModulo
import br.com.montesenior.aplicativo.components.TopBarCurso
import br.com.montesenior.aplicativo.model.CursoItem
import br.com.montesenior.aplicativo.model.usuarioMock
import br.com.montesenior.aplicativo.repository.ModuloRepository

@Composable
fun MenuCursoScreen(cursoItem: CursoItem, navController: NavController) {
    val modulos = ModuloRepository.modulos.values.toList()
    Scaffold(
        topBar = {
            TopBarCurso(
                nomeCurso = cursoItem.titulo,
                usuario = usuarioMock,
                comandoVoltar = {
                    navController.navigate("cursos")
                }
            )
        },
        modifier = Modifier.fillMaxSize()
    ) { innerPadding ->
        LazyColumn(
            modifier = Modifier
                .padding(innerPadding)
                .fillMaxSize()
                .padding(horizontal = 16.dp)
        ) {
            items(modulos) { modulo ->
                Spacer(modifier = Modifier.height(8.dp))
                CardModulo(
                    titulo = modulo.titulo,
                    descricao = modulo.descricao,
                    imagem = modulo.imagem,
                    navController = navController,
                    moduloId = modulo.id
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }

    }
}