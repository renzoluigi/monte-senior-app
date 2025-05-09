

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.components.TopBarVideoAula
import br.com.montesenior.aplicativo.repository.QuizRepository
import br.com.montesenior.aplicativo.screens.QuizResultScreen
import br.com.montesenior.aplicativo.screens.QuizScreenViewModel
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun QuizScreen(
    onQuizCompleted: () -> Unit,
    navController: NavController,
    viewModel: QuizScreenViewModel,
    tarefaId: String
) {
    val currentQuestion by viewModel.currentQuestion.observeAsState(0)
    val score by viewModel.score.observeAsState(0)
    val isCompleted by viewModel.isCompleted.observeAsState(false)
    val selectedAnswer by viewModel.selectedAnswer.observeAsState(null)
    val questoes = QuizRepository.quizzes.getValue(tarefaId).questoes

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.White)
    ) {
        TopBarVideoAula(
            tipo = "Quiz",
            tituloAula = "Introdução ao Etarismo",
            navController = navController
        )
        if (isCompleted) {
            QuizResultScreen(
                score = score,
                totalQuestions = questoes.size,
                onRetry = {
                    viewModel.onRetry()
                },
                navController = navController,
                onFinish = onQuizCompleted
            )
        } else {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(16.dp),
                verticalArrangement = Arrangement.spacedBy(24.dp)
            ) {
                item {
                    Text(
                        text = "Questão ${currentQuestion + 1}/${questoes.size}",
                        style = MaterialTheme.typography.titleMedium,
                        color = AzulMarinho,
                        fontWeight = FontWeight.Bold
                    )
                    Spacer(modifier = Modifier.height(16.dp))
                    Text(
                        text = questoes[currentQuestion].pergunta,
                        style = MaterialTheme.typography.titleLarge,
                        fontSize = 20.sp,
                        fontWeight = FontWeight.SemiBold
                    )
                }
                items(questoes[currentQuestion].opcoes.size) { index ->
                    val isSelected = selectedAnswer == index
                    Surface(
                        modifier = Modifier
                            .fillMaxWidth()
                            .selectable(
                                selected = isSelected,
                                onClick = {
                                    viewModel.onAnswerSelected(index)
                                }
                            ),
                        shape = RoundedCornerShape(12.dp),
                        color = when {
                            isSelected -> Color.Green.copy(alpha = 0.2f)
                            else -> Color.White
                        },
                        border = BorderStroke(
                            width = 1.dp,
                            color = when {
                                isSelected -> AzulMarinho
                                else -> Color.LightGray
                            }
                        )
                    ) {
                        Text(
                            text = questoes[currentQuestion].opcoes[index],
                            modifier = Modifier.padding(16.dp),
                            style = MaterialTheme.typography.bodyLarge
                        )
                    }
                }
                item {
                    Spacer(modifier = Modifier.height(24.dp))
                    Button(
                        onClick = {
                            viewModel.onNextQuestion(
                                questoes[currentQuestion].posicaoDaCorreta,
                                questoes.size
                            )
                        },
                        modifier = Modifier
                            .fillMaxWidth()
                            .height(50.dp),
                        enabled = selectedAnswer != null,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = AzulMarinho,
                            disabledContainerColor = AzulMarinho.copy(alpha = 0.5f)
                        )
                    ) {
                        Text(
                            text = if (currentQuestion < questoes.size - 1) "Próxima" else "Finalizar",
                            color = Color.White,
                            fontSize = 16.sp
                        )
                    }
                }
            }
        }
    }
}
