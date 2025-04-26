package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun DetalhesCursoScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box(
            modifier = Modifier
                .height(400.dp)
                .fillMaxWidth()
        ) {
            Image(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp),
                painter = painterResource(id = R.drawable.auxilio),
                contentDescription = "Imagem de um cuidador de idoso auxiliando uma idosa",
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .background(Color.Black.copy(alpha = 0.2f))
            )
            Column(
                modifier = Modifier
                    .padding(16.dp)
                    .clickable(onClick = {
                        navController.navigate("cursos")
                    })
            ) {
                Text(
                    text = "< Voltar",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 20.sp,
                )
            }
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(400.dp)
                    .padding(horizontal = 20.dp, vertical = 20.dp),
                verticalArrangement = Arrangement.Bottom
            ) {
                Image(
                    painter = painterResource(id = R.drawable.logo),
                    contentDescription = "Logo da empresa",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier
                        .scale(1.4f)
                        .offset(y = 15.dp)
                )
                Text(
                    "Curso de formação de cuidador de idosos",
                    fontFamily = Poppins,
                    color = Color.White,
                    fontSize = 26.sp,
                    fontWeight = FontWeight.Bold
                )
            }
        }
        LazyColumn(
            modifier = Modifier
                .fillMaxWidth()
                .weight(1f) // Faz a LazyColumn ocupar o espaço restante
                .padding(16.dp)
        ) {
            item {
                Text(
                    text = "Detalhes do Curso",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 8.dp),
                    verticalAlignment = androidx.compose.ui.Alignment.CenterVertically
                ) {
                    Text(
                        text = "Carga horária:",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                    Text(
                        text = "80 horas",
                        fontFamily = Poppins,
                        fontSize = 16.sp,
                        color = Color.DarkGray,
                        modifier = Modifier.padding(start = 8.dp)
                    )
                }
                Text(
                    text = "Este curso abrangente oferece uma formação completa para cuidadores de idosos. Você aprenderá técnicas essenciais de higiene, alimentação, mobilização e primeiros socorros, além de desenvolver habilidades de comunicação e empatia para lidar com as necessidades emocionais dos pacientes. Nosso programa é ministrado por profissionais experientes e oferece tanto teoria quanto prática para garantir que você esteja preparado para oferecer um cuidado de qualidade e humanizado.",
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Conteúdo Programático:",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.Bold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Módulo 01 (25 H)",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "A profissão e as responsabilidades do Cuidador de pessoa Idosa.\n" +
                            "• Auxílio no desenvolvimento emocional, social e cognitivo da pessoa idosa\n" +
                            "• Entendendo o envelhecimento: definição de geriatria e gerontologia;\n" +
                            "• Como o cérebro amadurece (aprendizado e reações),\n" +
                            "• Conceitos de envelhecimento: quem é o idoso no Brasil, senescência, senilidade, autonomia, independência;\n" +
                            "• Desenvolvimento Cognitivo na terceira Idade: raciocínio, memória e processamento de informações na 3° idade;\n" +
                            "• Desenvolvimento do idoso (Maslow e erickson), ganhos cognitivos da terceira idade;\n" +
                            "• Depressão e ansiedade;\n" +
                            "• Desenvolvimento psicossocial, processo de identidade na velhice (self e envelhecimento);\n" +
                            "• Seletividade emocional Benefícios das atividades cotidianas, otimismo e pessimismo em pessoas da terceira idade;\n" +
                            "• Independência e dependência A importância da socialização;\n" +
                            "• Ciclo de vida: luto em idosos, perspectiva sobre o morrer, escolhas de morte.",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Módulo 02: (25H)",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "O processo de envelhecimento da pessoa idosa e os principais cuidados de higiene e conforto, saúde e alimentação." +
                            "• Principais agravos patológicos que acometem a pessoa idosa e o atendimento de Primeiros Socorros;\n" +
                            "• Conceito de geriatria e gerontologia; • Aspectos básicos do envelhecimento fisiológico e patológico;\n" +
                            "• Cuidados com a prevenção e transmissão de doenças infecto contagiosas;\n" +
                            "• Controles básicos de sinais vitais no idoso: pressão arterial, pulso periférico, temperatura, frequência respiratória;\n" +
                            "• Cuidados com higiene e organização do ambiente da pessoa idosa;\n" +
                            "• Cuidados com eliminações: incontinência urinária e fecal. Como cuidar do idoso com dispositivos urinários;\n" +
                            "• Ostomia o que é e noções de como cuidar; • Cuidados com higiene e conforto: banho no chuveiro, banho no leito;\n" +
                            "• Cuidados com a pele, prevenção de assaduras e lesão por pressão, noções básicas sobre cuidados com curativos;\n" +
                            "• Cuidados com mudança de posição na cama, como trocar roupa de idoso acamado, cuidados com vestuário e medidas de proteção ao idoso no domicílio;\n" +
                            "• Cuidados na administração da alimentação ao idoso: por boca (via oral) e conhecendo outras vias de alimentação (nasoenteral ou gastrostomia);\n" +
                            "• Cuidados com administração de medicação VO, organização dos medicamentos que devem ser administrados;\n" +
                            "• Cuidados com os principais agravos cardiovasculares: acidente vascular cerebral, hipertensão, diabetes;\n" +
                            "• Prevenção dos principais agravos de urgência e emergência: Parada Cardiorrespiratória, engasgo, intoxicação, crise convulsiva e desmaio;\n" +
                            "• Calendário vacinal;\n" +
                            "• Estratégias de comunicação entre equipe e familiares; \n" +
                            "• Assistência de enfermagem nas demências em suas fases: leve, moderada e grave;\n" +
                            "• Assistência aos idosos em cuidados paliativos e em terminalidade.",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Módulo 03: (20 H)",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Auxílio na reabilitação da pessoa idosa acometida por imobilidade prejudicada, incontinências e adaptações pós sequelas: prevenção e diminuição das incapacidades, com o objetivo de proporcionar a qualidade de vida e a autonomia.\n" +
                            "• Principais agravos respiratórios Doenças respiratórias;\n" +
                            "• Prevenção de quedas e adaptação ambiental; • Adaptação ambiental e deficiências sensoriais;\n" +
                            "• Adaptação pós sequelas motoras;\n" +
                            "• Incontinência urinária e incontinência fecal;\n" +
                            "• Técnicas de Transferência da Cama para Cadeira e Vice-versa.",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Módulo 04: (10H)",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 4.dp)
                )
                Text(
                    text = "Marketing Pessoal, elaboração do currículo. auxílio no desenvolvimento profissional.\n" +
                            "• Mercado de trabalho para o cuidador: como ingressar na área;\n" +
                            " estratégias de colocação no mercado de trabalho, currículo, elaboração e envio;\n" +
                            " • Desempenho na entrevista: modalidades de entrevista, avaliação de comportamento e habilidades na entrevista;\n" +
                            " • Atuação e atribuições do cuidador de idosos junto a equipe multidisciplinar.",
                    fontFamily = Poppins,
                    fontSize = 14.sp,
                    modifier = Modifier.padding(bottom = 16.dp)
                )
                Text(
                    text = "Certificado de Conclusão",
                    fontFamily = Poppins,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 18.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Imagem do certificado...",
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp)
                )
                Text(
                    text = "Mais informações sobre o curso...",
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 8.dp),
                    color = Color.Blue
                )
                Text(
                    text = "Entre em contato conosco para saber mais detalhes e realizar sua inscrição!",
                    fontFamily = Poppins,
                    fontSize = 16.sp,
                    modifier = Modifier.padding(bottom = 32.dp)
                )
            }
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun DetalhesCursoScreenPreview() {
    DetalhesCursoScreen(modifier = Modifier, navController = NavController(LocalContext.current))
}