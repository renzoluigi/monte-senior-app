package br.com.montesenior.aplicativo.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun QuizResultScreen(
    score: Int,
    totalQuestions: Int,
    onRetry: () -> Unit,
    navController: NavController,
    onFinish : () -> Unit
) {
    val percentage = (score.toFloat() / totalQuestions.toFloat()) * 100

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            text = "Resultado do Quiz",
            style = MaterialTheme.typography.headlineMedium,
            color = AzulMarinho,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.padding(bottom = 24.dp)
        )
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .size(150.dp)
                .background(
                    color = when {
                        percentage >= 70 -> Color.Green.copy(alpha = 0.2f)
                        percentage >= 50 -> Color.Yellow.copy(alpha = 0.2f)
                        else -> Color.Red.copy(alpha = 0.2f)
                    },
                    shape = RoundedCornerShape(75.dp)
                )
                .border(
                    width = 2.dp,
                    color = when {
                        percentage >= 70 -> Color.Green
                        percentage >= 50 -> Color.Yellow
                        else -> Color.Red
                    },
                    shape = RoundedCornerShape(75.dp)
                )
        ) {
            Column(horizontalAlignment = Alignment.CenterHorizontally) {
                Text(
                    text = "$score/$totalQuestions",
                    style = MaterialTheme.typography.displaySmall,
                    fontWeight = FontWeight.Bold
                )
                Text(
                    text = "%.0f%%".format(percentage),
                    fontSize = 20.sp
                )
            }
        }
        Spacer(modifier = Modifier.height(32.dp))
        Text(
            text = when {
                percentage >= 70 -> "Excelente! Você dominou o conteúdo!"
                percentage >= 50 -> "Bom trabalho! Revise alguns pontos."
                else -> "Revise o conteúdo! Você pode melhorar."
            },
            textAlign = TextAlign.Center,
            fontSize = 18.sp,
            modifier = Modifier.padding(horizontal = 24.dp)
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(
            onClick = {
                if (score == 2) {
                    navController.popBackStack()
                    onFinish()
                } else {
                    onRetry()
                }
            },
            modifier = Modifier
                .fillMaxWidth()
                .height(50.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = AzulMarinho
            )
        ) {
            Text(
                text = if (score == 2) "Finalizar" else "Refazer o Quiz",
                color = Color.White,
                fontSize = 16.sp
            )
        }
    }
}