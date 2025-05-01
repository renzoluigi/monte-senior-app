
import androidx.compose.animation.core.animateFloatAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun CertificadoScreen() {
    var isButtonClicked by remember { mutableStateOf(false) }
    val scale by animateFloatAsState(
        targetValue = if (isButtonClicked) 0.95f else 1f,
        animationSpec = tween(durationMillis = 150)
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        var rotation by remember { mutableStateOf(0f) }
        val animatedRotation by animateFloatAsState(
            targetValue = rotation,
            animationSpec = tween(durationMillis = 500)
        )

        Image(
            painter = painterResource(id = R.drawable.trofeu),
            contentDescription = "Parabéns!",
            modifier = Modifier
                .size(140.dp)
                .graphicsLayer { rotationZ = animatedRotation }
                .clickable { rotation += 30f }
        )

        Spacer(modifier = Modifier.height(24.dp))

        Text(
            text = "Parabéns!",
            fontSize = 36.sp,
            fontWeight = FontWeight.Bold,
            color = AzulMarinho,
            textAlign = TextAlign.Center
        )

        Spacer(modifier = Modifier.height(16.dp))

        Text(
            text = "Você concluiu esta etapa com sucesso!\nSeu esforço e dedicação são muito importantes.",
            fontSize = 18.sp,
            color = Color.Gray,
            textAlign = TextAlign.Center,
            fontFamily = Poppins
        )

        Spacer(modifier = Modifier.height(32.dp))

        Button(
            onClick = {
                isButtonClicked = true
            },
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 48.dp)
                .scale(scale),
            colors = ButtonDefaults.buttonColors(containerColor = AzulMarinho),
            shape = RoundedCornerShape(28.dp),
            elevation = ButtonDefaults.buttonElevation(defaultElevation = 6.dp, pressedElevation = 2.dp)
        ) {
            Text(
                text = "Pegar seu Certificado",
                color = Color.White,
                fontSize = 16.sp,
                fontWeight = FontWeight.SemiBold,
                modifier = Modifier.padding(vertical = 8.dp),
                fontFamily = Poppins
            )
        }
    }
}

@Preview(showBackground = true, showSystemUi = true)
@Composable
private fun CertificadoScreenPreview() {
    CertificadoScreen()
}