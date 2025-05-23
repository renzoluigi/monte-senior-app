package br.com.montesenior.aplicativo.screens.menu

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
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
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import br.com.montesenior.aplicativo.components.TextFieldEdit
import br.com.montesenior.aplicativo.data.model.Usuario
import br.com.montesenior.aplicativo.ui.theme.BlueMonteSenior

@Composable
fun EditarPerfilScreen(usuario: Usuario, onSalvarClick: (Usuario) -> Unit, onVoltarClick: () -> Unit) {
    var nome by remember { mutableStateOf(usuario.nome) }
    var genero by remember { mutableStateOf(usuario.genero) }
    var email by remember { mutableStateOf(usuario.email) }
    var endereco by remember { mutableStateOf(usuario.endereco) }
    var telefone by remember { mutableStateOf(usuario.telefone) }
    var nascimento by remember { mutableStateOf(usuario.dataNascimento) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp)
    ) {
        Text(
            text = "Editar Informações",
            fontSize = 22.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier.align(Alignment.CenterHorizontally)
        )

        Spacer(modifier = Modifier.height(20.dp))

        TextFieldEdit(label = "Nome", valor = nome, onValorChange = { nome = it })
        TextFieldEdit(label = "Gênero", valor = genero, onValorChange = { genero = it })
        TextFieldEdit(label = "Email", valor = email, onValorChange = { email = it })
        TextFieldEdit(label = "Endereço", valor = endereco, onValorChange = { endereco = it })
        TextFieldEdit(label = "Telefone", valor = telefone, onValorChange = { telefone = it })
        TextFieldEdit(label = "Data de Nascimento", valor = nascimento, onValorChange = { nascimento = it })

        Spacer(modifier = Modifier.height(20.dp))

        Row(
            modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Button(
                onClick = onVoltarClick,
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = Color.LightGray)
            ) {
                Text("Cancelar", color = Color.Black)
            }

            Spacer(modifier = Modifier.width(16.dp))

            Button(
                onClick = {
//                    onSalvarClick(
//                        usuario.copy(
//                            nome = nome,
//                            genero = genero,
//                            email = email,
//                            endereco = endereco,
//                            telefone = telefone,
//                            dataNascimento = nascimento
//                        )
//                    )
                },
                modifier = Modifier.weight(1f),
                shape = RoundedCornerShape(10.dp),
                colors = ButtonDefaults.buttonColors(containerColor = BlueMonteSenior)
            ) {
                Text("Salvar")
            }
        }
    }
}