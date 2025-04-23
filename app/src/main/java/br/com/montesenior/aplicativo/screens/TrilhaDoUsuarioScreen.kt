package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.CardTarefaSimples
import br.com.montesenior.aplicativo.model.AtividadeItem

@Composable
fun TrilhaDoUsuarioScreen() {
    val atividades = listOf(
        AtividadeItem("Introdução", "Uma visão geral dos principais tópicos que abordaremos para te ajudar no dia a dia do cuidado.", R.drawable.didatic),
        AtividadeItem("Habilidades Básicas de Cuidado", "Desenvolva as habilidades" +
                " essenciais que todo cuidador de idosos precisa para garantir o conforto, a segurança e o bem-estar " +
                "no dia a dia.", R.drawable.habilidade),
        AtividadeItem("Atividade 3", "Descrição rápida da tarefa 3", R.drawable.auxilio),
        AtividadeItem("Atividade 4", "Descrição rápida da tarefa 4", R.drawable.higiene),
        AtividadeItem("Atividade 5", "Descrição rápida da tarefa 5", R.drawable.ultimo),
    )

    Column(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .background(Color(0xFF43C437))
                .padding(16.dp)
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier.fillMaxWidth()
            ) {
                Row(verticalAlignment = Alignment.CenterVertically) {
                    Image(
                        painter = painterResource(id = R.drawable.foto),
                        contentDescription = "Perfil",
                        modifier = Modifier
                            .size(50.dp)
                            .clip(CircleShape),
                        contentScale = ContentScale.Crop
                    )
                    Spacer(modifier = Modifier.width(12.dp))
                    Column {
                        Text(
                            text = "Marconi Luckas",
                            fontSize = 18.sp,
                            fontWeight = FontWeight.Bold,
                            color = Color.White
                        )
                        Text(
                            text = "Progresso: 30%",
                            fontSize = 14.sp,
                            color = Color.White
                        )
                    }
                }
                Icon(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 16.dp),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            items(atividades) { atividade ->
                CardTarefaSimples(
                    titulo = atividade.titulo,
                    descricao = atividade.descricao,
                    imagem = atividade.imagem
                )
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}