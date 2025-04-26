
import androidx.compose.foundation.Image
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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun Screen() {
    Column(modifier = Modifier.fillMaxSize()) {
        Box {
            Image(
                painter = painterResource(id = R.drawable.elderlycare),
                contentDescription = "",
                modifier = Modifier
                    .fillMaxWidth()
                    .height(500.dp),
                contentScale = ContentScale.Crop
            )
            Image(
                painter = painterResource(id = R.drawable.logo),
                contentDescription = "Logo Monte Senior",
                modifier = Modifier
                    .size(100.dp)
            )


            Text(
                text = "Voltar >",
                fontFamily = Poppins,
                fontSize = 18.sp,
                fontWeight = FontWeight.Medium,
                color = Color.White,
                modifier = Modifier
                    .align(Alignment.TopEnd)
                    .padding(top = 24.dp, end = 16.dp)
            )
        }

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp)
        ) {
            Text(
                text = "Cuidadores de apoio domiciliar",
                fontSize = 20.sp,
                fontWeight = FontWeight.Bold,
                fontFamily = Poppins,
                color = Color.Black,
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "Oferecemos cuidados domiciliares personalizados para garantir" +
                        " conforto, segurança e bem-estar na rotina dos idosos. Auxiliamos em" +
                        " tarefas do dia a dia, como alimentação, higiene pessoal e outras" +
                        " atividades essenciais, sempre respeitando as necessidades e preferências" +
                        " de cada pessoa.",
                fontSize = 14.sp,
                lineHeight = 20.sp,
                color = Color.DarkGray,
                fontFamily = Poppins
            )

            Spacer(modifier = Modifier.height(30.dp))

            Button(
                onClick = { /* TODO: ação saiba mais */ },
                modifier = Modifier
                    .fillMaxWidth()
                    .height(50.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueMonteSenior),
                shape = RoundedCornerShape(25.dp)
            ) {
                Text(
                    text = "Saiba mais",
                    fontSize = 16.sp,
                    fontWeight = FontWeight.Medium,
                    color = Color.White,
                    fontFamily = Poppins
                )
            }
        }
    }
}
