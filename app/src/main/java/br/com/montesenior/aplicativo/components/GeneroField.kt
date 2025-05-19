package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.ExposedDropdownMenuBox
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import br.com.montesenior.aplicativo.ui.theme.Poppins

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GeneroField(
    generoSelecionado: String,
    onGeneroChanged: (String) -> Unit
) {
    val generos = listOf(
        "Masculino",
        "Feminino",
        "Outro"
    )
    var expandido by remember {
        mutableStateOf(false)
    }

    ExposedDropdownMenuBox(
        expanded = expandido,
        onExpandedChange = { expandido = !expandido },
        modifier = Modifier.fillMaxWidth()
    ) {
        OutlinedTextField(
            readOnly = true,
            value = generoSelecionado,
            onValueChange = {
            },
            label = {
                Text(text = "Selecione seu gênero")
            },
            trailingIcon = {
                Icon(
                    imageVector = Icons.Filled.ArrowDropDown,
                    contentDescription = null
                )
            },
            colors = TextFieldDefaults.colors(

            ),
            modifier = Modifier.menuAnchor().fillMaxWidth(),
            shape = RoundedCornerShape(20.dp)
        )
        ExposedDropdownMenu(
            expanded = expandido,
            onDismissRequest = { expandido = false }
        ) {
            generos.forEach { genero ->
                DropdownMenuItem(
                    text = {
                        Text(text = genero, fontFamily = Poppins)
                    },
                    onClick = {
                        onGeneroChanged(genero)
                        expandido = false
                    }
                )
            }
        }
    }
}