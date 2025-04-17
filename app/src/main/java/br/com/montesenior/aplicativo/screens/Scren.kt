

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior

// Modelo temporário
data class MaterialItem(
    val titulo: String,
    val descricao: String,
    val imagem: Int
)

@Composable
fun TelaSelecaoMaterial() {
    val materiais = listOf(
        MaterialItem("Auxílio na alimentação para idosos", "Aqui, você encontrará informações e orientações essenciais para apoiar idosos com dificuldades alimentares.", R.drawable.auxilio),
        MaterialItem("Bem-estar e higiene pessoal do idoso","Aprenda a auxiliar em rotinas, adaptar cuidados e promover conforto físico e emocional.",R.drawable.higiene),
        MaterialItem("Título 3", "Descrição breve do conteúdo 3", R.drawable.ultimo),
    )

    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ) {
        items(materiais) { item ->
            CardMaterial(item)
        }
    }
}

@Composable
fun CardMaterial(item: MaterialItem) {
    Card(
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(6.dp),
        modifier = Modifier.fillMaxWidth()
    ) {
        Column {
            Image(
                painter = painterResource(id = item.imagem),
                contentDescription = item.titulo,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(160.dp),
                contentScale = ContentScale.Crop
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = item.titulo,
                fontSize = 18.sp,
                fontWeight = FontWeight.Bold,
                modifier = Modifier.padding(horizontal = 16.dp)
            )

            Text(
                text = item.descricao,
                fontSize = 14.sp,
                color = Color.Gray,
                modifier = Modifier.padding(horizontal = 16.dp, vertical = 4.dp)
            )

            Spacer(modifier = Modifier.height(8.dp))

            Button(
                onClick = { /* TODO: ação ao clicar */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 16.dp, vertical = 8.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueMonteSenior),
                shape = RoundedCornerShape(20.dp)
            ) {
                Text("Entrar")
            }
        }
    }
}

data class AtividadeItem(
    val titulo: String,
    val descricao: String,
    val imagem: Int // Adicione a propriedade imagem
)

@Composable
fun TelaTrilhaUsuario() {
    // Lista de atividades (substitua por seus dados reais)
    val atividades = listOf(
        AtividadeItem("Introdução", "Uma visão geral dos principais tópicos que abordaremos para te ajudar no dia a dia do cuidado.", R.drawable.didatic),
        AtividadeItem("Habilidades Básicas de Cuidado", "Desenvolva as habilidades" +
                " essenciais que todo cuidador de idosos precisa para garantir o conforto, a segurança e o bem-estar " +
                "no dia a dia.", R.drawable.habilidade),
        AtividadeItem("Atividade 3", "Descrição rápida da tarefa 3", R.drawable.auxilio),
        AtividadeItem("Atividade 4", "Descrição rápida da tarefa 4", R.drawable.higiene),
        AtividadeItem("Atividade 5", "Descrição rápida da tarefa 5", R.drawable.ultimo),
        // Adicione mais atividades conforme necessário
    )

    Column(modifier = Modifier.fillMaxSize()) {
        // TOPO COM PERFIL
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
                        painter = painterResource(id = R.drawable.foto), // Sua imagem de perfil
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

                // Algum ícone ou menu (opcional)
                Icon(
                    painter = painterResource(id = R.drawable.logo), // Placeholder
                    contentDescription = "Menu",
                    tint = Color.White
                )
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        // LISTA DE ATIVIDADES COM LAZYCOLUMN
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
                    imagem = atividade.imagem // Passe a imagem para o CardTarefaSimples
                )
            }

            item {
                Spacer(modifier = Modifier.height(32.dp))
            }
        }
    }
}

@Composable
fun CardTarefaSimples(titulo: String, descricao: String, imagem: Int) {
    Card(
        shape = RoundedCornerShape(20.dp),
        elevation = CardDefaults.cardElevation(8.dp),
        modifier = Modifier
            .fillMaxWidth()
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Topo com título e botão
            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Image(
                    painter = painterResource(id = imagem), // Use a imagem passada como parâmetro
                    contentDescription = "Ícone da $titulo",
                    modifier = Modifier.size(48.dp)
                )
                Spacer(modifier = Modifier.width(16.dp))
                Column(modifier = Modifier.weight(1f)) {
                    Text(titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
                    Text(descricao, fontSize = 14.sp, color = Color.Gray)
                }
                Button(
                    onClick = { /* TODO: ação */ },
                    shape = RoundedCornerShape(20.dp),
                    colors = ButtonDefaults.buttonColors(BlueMonteSenior)
                ) {
                    Text("Começar", color = Color.White)
                }
            }

            Spacer(modifier = Modifier.height(24.dp))

            // Trilha destacada
            Text(
                text = "Sua Trilha de Aprendizado",
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(12.dp))

            LazyRow(
                horizontalArrangement = Arrangement.spacedBy(16.dp),
                modifier = Modifier
                    .fillMaxWidth()
                    .height(200.dp)
                    .padding(horizontal = 8.dp)
            ) {
                items(trilhaItens) { item ->
                    TrilhaCard(
                        imagem = item.imagem,
                        titulo = item.titulo,
                        onClick = { /* TODO: ação específica */ }
                    )
                }
            }
        }
    }
}


@Composable
fun TrilhaCard(imagem: Int, titulo: String, onClick: () -> Unit) {
    Card(
        modifier = Modifier
            .width(140.dp)
            .fillMaxHeight()
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp),
        colors = CardDefaults.cardColors(containerColor = Color(0xFFF0F4FF))
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier.padding(16.dp)
        ) {
            Image(
                painter = painterResource(id = imagem),
                contentDescription = titulo,
                modifier = Modifier
                    .size(60.dp)
                    .clip(CircleShape)
            )
            Spacer(modifier = Modifier.height(12.dp))
            Text(
                text = titulo,
                fontSize = 14.sp,
                fontWeight = FontWeight.Medium,
                textAlign = TextAlign.Center
            )
        }
    }
}

data class TrilhaItem(val imagem: Int, val titulo: String)

val trilhaItens = listOf(
    TrilhaItem(R.drawable.estudante, "Leia o Material"),
    TrilhaItem(R.drawable.prova, "Responda o Quiz"),
    TrilhaItem(R.drawable.logo, "Conclua a Atividade")
)

