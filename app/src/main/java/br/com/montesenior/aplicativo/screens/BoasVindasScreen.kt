package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.CozyBlue
import br.com.montesenior.aplicativo.ui.theme.PoppinsBold

@Composable
fun BoasVindasScreen(modifier: Modifier = Modifier, navController: NavController) {
    Column(modifier = Modifier.fillMaxSize()) {
        Box() {
            Image(
                painter = painterResource(id = R.drawable.imagem_boas_vindas),
                contentDescription = "Imagem um cuidador de idosos com um idoso",
                modifier = Modifier.fillMaxSize(),
                contentScale = ContentScale.Crop
            )
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(300.dp)
                    .align(Alignment.BottomCenter),
                colors = CardDefaults.cardColors(CozyBlue),
                shape = RoundedCornerShape(topStart = 30.dp, topEnd = 30.dp),
                elevation = CardDefaults.cardElevation(10.dp)
            ) {
                Column(modifier = Modifier
                    .fillMaxSize()
                    .padding(20.dp)) {
                    Text(
                        text = "Seja bem vindo ao app da Monte Senior!",
                        color = Color.White,
                        fontFamily = PoppinsBold,
                        fontSize = 25.sp
                    )
                    Spacer(modifier = Modifier.height(10.dp))
                    Text(
                        text = "Escolha uma das opções abaixo para continuar.",
                        fontFamily = PoppinsBold,
                        color = Color.White
                    )
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            navController.navigate("registro")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Text(
                            text = "Ainda nâo tenho uma conta",
                            color = CozyBlue,
                            fontFamily = PoppinsBold,
                            fontSize = 16.sp
                        )
                    }
                    Spacer(modifier = Modifier.height(20.dp))
                    Button(
                        onClick = {
                            navController.navigate("login")
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        colors = ButtonDefaults.buttonColors(Color.White),
                        shape = RoundedCornerShape(5.dp),
                    ) {
                        Text(
                            text = "Já tenho uma conta.",
                            color = CozyBlue,
                            fontFamily = PoppinsBold,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }

    }
}


@Preview(showSystemUi = true, showBackground = true)
@Composable
private fun BoasVindasScreenPreview() {
    BoasVindasScreen(navController = NavController(LocalContext.current))
}