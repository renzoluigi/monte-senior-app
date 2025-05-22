package br.com.montesenior.aplicativo.screens.authentication

import android.content.Context
import android.net.Uri
import android.util.Log
import androidx.activity.compose.rememberLauncherForActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Send
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import br.com.montesenior.aplicativo.R
import br.com.montesenior.aplicativo.components.VoltarColumnButton
import br.com.montesenior.aplicativo.data.service.CloudinaryService
import br.com.montesenior.aplicativo.ui.theme.AzulMarinho
import coil3.compose.rememberAsyncImagePainter
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.MultipartBody
import okhttp3.RequestBody.Companion.toRequestBody
import org.json.JSONObject
import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import java.net.URLEncoder
import java.nio.charset.StandardCharsets

@Composable
fun EnviarImagemScreen( // TODO: VIEW MODEL
    nome: String,
    email: String,
    telefone: String,
    genero: String,
    navController: NavController
) {
    val contexto = LocalContext.current
    var imagemSelecionadaUri by remember { mutableStateOf<Uri?>(null) }
    val coroutineScope = rememberCoroutineScope()
    val launcher =
        rememberLauncherForActivityResult(ActivityResultContracts.GetContent()) { uri -> // abre o seletor de imagens
            imagemSelecionadaUri = uri // recebe o uri da imagem selecionada
        }
    var isCarregando by remember { mutableStateOf(false) }

    Box(modifier = Modifier.fillMaxSize()) {
        Image(
            painter = painterResource(id = R.drawable.lightblue_bg),
            contentDescription = "Plano de fundo",
            modifier = Modifier.fillMaxSize(),
            contentScale = ContentScale.Crop
        )
        VoltarColumnButton(
            onClick = {
                navController.popBackStack()
            }
        )
        Column(
            modifier = Modifier
                .fillMaxSize(),
            verticalArrangement = Arrangement.Center
        ) {
            Card(
                shape = RoundedCornerShape(30.dp),
                elevation = CardDefaults.cardElevation(10.dp),
                modifier = Modifier.padding(horizontal = 20.dp)
            ) {
                Column(
                    modifier = Modifier
                        .padding(20.dp)
                ) {
                    Text(
                        text = "Anexar foto",
                        fontWeight = FontWeight.Bold,
                        fontSize = 28.sp
                    )
                    Text(text = "Adicione uma foto para seu perfil!")
                    Spacer(modifier = Modifier.height(8.dp))
                    Column(verticalArrangement = Arrangement.spacedBy(8.dp)) {
                        Box(
                            modifier = Modifier
                                .height(200.dp)
                                .fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            imagemSelecionadaUri?.let { uri ->
                                Image(
                                    painter = rememberAsyncImagePainter(uri),
                                    contentDescription = "Imagem selecionada",
                                    modifier = Modifier
                                        .size(200.dp)
                                        .clip(CircleShape),
                                    contentScale = ContentScale.FillBounds
                                )
                            }
                        }
                        Button(
                            onClick = {
                                launcher.launch("image/*")
                            },
                            modifier = Modifier.fillMaxWidth().height(50.dp),
                            shape = RoundedCornerShape(10.dp),
                            colors = ButtonDefaults.buttonColors(AzulMarinho)
                        ) {
                            Text("Selecionar Imagem")
                            Spacer(modifier = Modifier.width(8.dp))
                            Icon(
                                painter = painterResource(R.drawable.outline_upload),
                                contentDescription = "Selecionar Imagem"
                            )
                        }
                        if (isCarregando) {
                            CircularProgressIndicator(modifier = Modifier.align(Alignment.CenterHorizontally))
                        } else {
                            Button(
                                onClick = {
                                    imagemSelecionadaUri?.let { uri ->
                                        isCarregando = true
                                        uploadImagemParaCloudinary(
                                            contexto = contexto,
                                            uri = uri,
                                            onSucesso = { url ->
                                                coroutineScope.launch(Dispatchers.Main) {
                                                    isCarregando = false
                                                    try {
                                                        val encodedUrl = URLEncoder.encode(
                                                            url,
                                                            StandardCharsets.UTF_8.toString()
                                                        )
                                                        navController.navigate("completar-registro/$nome/$email/$telefone/$genero/$encodedUrl")
                                                    } catch (e: Exception) {
                                                        Log.e(
                                                            "EnviarImagemScreen",
                                                            "Erro ao codificar URL ou navegar: ${e.message}"
                                                        )
                                                    }
                                                }
                                            },
                                            onErro = { e ->
                                                coroutineScope.launch(Dispatchers.Main) {
                                                    isCarregando = false
                                                    Log.e(
                                                        "ImageUploadScreen",
                                                        "Erro ao fazer upload da imagem: ${e.message}"
                                                    )
                                                }
                                            }
                                        )
                                    }
                                },
                                modifier = Modifier.fillMaxWidth().height(50.dp),
                                shape = RoundedCornerShape(10.dp),
                                colors = ButtonDefaults.buttonColors(AzulMarinho)
                            ) {
                                Text(text = "Enviar Imagem")
                                Spacer(modifier = Modifier.width(8.dp))
                                Icon(
                                    imageVector = Icons.Default.Send,
                                    contentDescription = "Enviar Imagem",
                                    modifier = Modifier.size(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}


fun uploadImagemParaCloudinary(
    contexto: Context,
    uri: Uri,
    onSucesso: (String) -> Unit,
    onErro: (Throwable) -> Unit
) {
    val contentResolver = contexto.contentResolver
    val inputStream = contentResolver.openInputStream(uri) ?: return
    val bytes = inputStream.readBytes()
    val requestBody = bytes.toRequestBody("image/*".toMediaTypeOrNull())
    val filePart = MultipartBody.Part.createFormData(
        "file",
        "image.jpg",
        requestBody
    )
    val preset = "montesenior_preset".toRequestBody("text/plain".toMediaType())

    val retrofit = Retrofit.Builder()
        .baseUrl("https://api.cloudinary.com/")
        .addConverterFactory(ScalarsConverterFactory.create())
        .build()

    val service = retrofit.create(CloudinaryService::class.java)

    CoroutineScope(Dispatchers.IO).launch {
        try {
            val response = service.uploadImage(filePart, preset)
            val body = response.body()
            val bodyString = body?.string()
            val json = JSONObject(bodyString ?: throw Exception("Null response"))
            val url = json.getString("secure_url")
            onSucesso(url)
        } catch (e: Exception) {
            onErro(e)
        }
    }
}