package br.com.montesenior.aplicativo.screens.course

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.CardModulo
import br.com.montesenior.aplicativo.components.TopBarCurso
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.data.repository.SobreCursoRepository
import br.com.montesenior.aplicativo.data.repository.MaterialCursoRepository
import androidx.compose.runtime.getValue

@Composable
fun MenuCursoScreen(
    usuario: Usuario,
    uid: String,
    cursoId: String,
    navController: NavController
) {
    val menuCursoScreenViewModel: MenuCursoScreenViewModel = viewModel()
    val curso = SobreCursoRepository.cursos.getValue(cursoId)
    val modulos = MaterialCursoRepository.materialCursos.getValue(curso.cursoId).modulos
    val listaProgressoModulo by menuCursoScreenViewModel.listaProgressoModulo.observeAsState()
    val progresso by menuCursoScreenViewModel.progressoCurso.observeAsState(0)

    LaunchedEffect(uid, cursoId) {
        menuCursoScreenViewModel.carregarProgressoModulos(uid, cursoId)
    }

    BackHandler(enabled = true) {
        navController.navigate("cursos") {
            popUpTo(navController.graph.startDestinationId) {
                inclusive = true
            }
            launchSingleTop = true
        }
    }
    Scaffold(
        topBar = {
            TopBarCurso(
                nomeCurso = curso.titulo,
                usuario = usuario,
                progresso = progresso.toInt(),
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
                    tarefas = modulo.tarefas,
                    cursoId = cursoId,
                    moduloId = modulo.id,
                    progressoModulo = listaProgressoModulo?.find { it.moduloId == modulo.id}
                )
                Spacer(modifier = Modifier.height(8.dp))
            }
        }
    }
}