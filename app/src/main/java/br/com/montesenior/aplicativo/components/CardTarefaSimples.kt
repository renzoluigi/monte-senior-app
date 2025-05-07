package br.com.montesenior.aplicativo.components

//@Composable
//fun CardTarefaSimples(titulo: String, descricao: String, imagem: Int) {
//    Card(
//        shape = RoundedCornerShape(20.dp),
//        elevation = CardDefaults.cardElevation(8.dp),
//        modifier = Modifier
//            .fillMaxWidth()
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Row(
//                verticalAlignment = Alignment.CenterVertically
//            ) {
//                Image(
//                    painter = painterResource(id = imagem),
//                    contentDescription = "Ícone da $titulo",
//                    modifier = Modifier.size(48.dp)
//                )
//                Spacer(modifier = Modifier.width(16.dp))
//                Column(modifier = Modifier.weight(1f)) {
//                    Text(titulo, fontSize = 18.sp, fontWeight = FontWeight.Bold)
//                    Text(descricao, fontSize = 14.sp, color = Color.Gray)
//                }
//                Button(
//                    onClick = { /* TODO: ação */ },
//                    shape = RoundedCornerShape(20.dp),
//                    colors = ButtonDefaults.buttonColors(BlueMonteSenior)
//                ) {
//                    Text("Começar", color = Color.White)
//                }
//            }
//
//            Spacer(modifier = Modifier.height(24.dp))
//            Text(
//                text = "Sua Trilha de Aprendizado",
//                fontSize = 16.sp,
//                fontWeight = FontWeight.SemiBold
//            )
//
//            Spacer(modifier = Modifier.height(12.dp))
//
//            LazyRow(
//                horizontalArrangement = Arrangement.spacedBy(16.dp),
//                modifier = Modifier
//                    .fillMaxWidth()
//                    .height(200.dp)
//                    .padding(horizontal = 8.dp)
//            ) {
//                items(trilhaItens) { item ->
//                    TrilhaCard(
//                        imagem = item.imagem,
//                        titulo = item.titulo,
//                        onClick = { /* TODO: ação específica */ }
//                    )
//                }
//            }
//        }
//    }
//}