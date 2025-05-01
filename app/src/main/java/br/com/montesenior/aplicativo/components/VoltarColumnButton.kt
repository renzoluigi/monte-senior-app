package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun VoltarColumnButton(navController: NavController, rota: String) {
    Column(modifier = Modifier.padding(16.dp)) {
        Text(
            text = "< Voltar",
            fontSize = 20.sp,
            fontWeight = FontWeight.Bold,
            color = AzulMarinho,
            modifier = Modifier.clickable(onClick = { navController.navigate(rota) })
        )
    }
}