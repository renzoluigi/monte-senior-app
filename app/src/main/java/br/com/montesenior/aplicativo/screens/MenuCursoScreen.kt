package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.layout.Arrangement
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
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardTarefaTrilha
import br.com.montesenior.aplicativo.components.TopBarCurso
import br.com.montesenior.aplicativo.model.AtividadeItem
import br.com.montesenior.aplicativo.model.CursoItem
import br.com.montesenior.aplicativo.model.Usuario
import br.com.montesenior.aplicativo.model.usuarioMock

@Composable
fun MenuCursoScreen(cursoItem: CursoItem, usuario: Usuario, navController: NavController) {
    val atividades = listOf(
        AtividadeItem(
            "Introdução",
            "Uma visão geral dos principais tópicos que abordaremos para te ajudar no dia a dia do cuidado.",
            R.drawable.didatic
        ),
        AtividadeItem(
            "Habilidades Básicas de Cuidado", "Desenvolva as habilidades" +
                    " essenciais que todo cuidador de idosos precisa para garantir o conforto, a segurança e o bem-estar " +
                    "no dia a dia.", R.drawable.habilidade
        ),
    )
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
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(atividades) { atividade ->
                CardTarefaTrilha(
                    titulo = atividade.titulo,
                    descricao = atividade.descricao,
                    imagem = atividade.imagem,
                    navController = navController
                )
            }
            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }

    }
}