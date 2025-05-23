package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.OutlinedTextFieldDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho

@Composable
fun TextFieldEdit(
    label: String,
    valor: String,
    onValorChange: (String) -> Unit
) {
    Column(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = label,
            fontWeight = FontWeight.Bold,
            fontSize = 14.sp
        )
        Spacer(modifier = Modifier.height(4.dp))
        OutlinedTextField(
            value = valor,
            onValueChange = onValorChange,
            modifier = Modifier
                .fillMaxWidth(),
            shape = RoundedCornerShape(10.dp),
            colors = OutlinedTextFieldDefaults.colors(
                focusedBorderColor = AzulMarinho,
                unfocusedBorderColor = Color.Gray,
                focusedTextColor = Color.Black,
                unfocusedTextColor = Color.DarkGray
            )
        )
        Spacer(modifier = Modifier.height(10.dp))
    }
}