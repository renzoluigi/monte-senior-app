package br.com.montesenior.aplicativo.components

import android.app.DatePickerDialog
import android.widget.DatePicker
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import br.com.montesenior.aplicativo.R
import java.util.Calendar

@Composable
fun DataNascimentoField(
    onDataNascimentoChanged: (String) -> Unit
) {
    var dataNascimento by remember {
        mutableStateOf("")
    }
    val calendario = Calendar.getInstance()
    val contexto = LocalContext.current
    val datePicker = remember {
        DatePickerDialog(
            contexto,
            { _: DatePicker, ano: Int, mes: Int, diaDoMes: Int ->
                dataNascimento = "$diaDoMes/${mes + 1}/$ano"
                onDataNascimentoChanged(dataNascimento)
            },
            calendario.get(Calendar.YEAR),
            calendario.get(Calendar.MONTH),
            calendario.get(Calendar.DAY_OF_MONTH)
        )
    }

    OutlinedTextField(
        value = dataNascimento,
        onValueChange = {
        },
        label = { Text(text = "Data de Nascimento") },
        modifier = Modifier.fillMaxWidth(),
        readOnly = true,
        trailingIcon = {
            Icon(
                painter = painterResource(id = R.drawable.calendar),
                contentDescription = null,
                modifier = Modifier.clickable {
                    datePicker.show()
                }
            )
        },
        shape = RoundedCornerShape(20.dp)
    )
}