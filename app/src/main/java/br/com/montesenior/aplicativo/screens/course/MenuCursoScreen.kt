package br.com.montesenior.aplicativo.screens.course

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
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.data.repository.SobreCursoRepository
import br.com.montesenior.aplicativo.data.repository.MaterialCursoRepository

@Composable
fun MenuCursoScreen(
    cursoId: String,
    navController: NavController,
    usuario: Usuario
) {
    val curso = SobreCursoRepository.cursos.getValue(cursoId)
    val modulos = MaterialCursoRepository.materialCursos.getValue(curso.cursoId).modulos

    Scaffold(
        topBar = {
            TopBarCurso(
                nomeCurso = curso.titulo,
                usuario = usuario,
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
                    tarefas = modulo.tarefas
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}