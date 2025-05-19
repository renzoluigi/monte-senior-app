package br.com.montesenior.aplicativo

import CursosScreen
import QuizScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.montesenior.aplicativo.components.NavBar
import br.com.montesenior.aplicativo.screens.BoasVindasScreen
import br.com.montesenior.aplicativo.screens.CompletarRegistroScreen
import br.com.montesenior.aplicativo.screens.LeituraConteudoScreen
import br.com.montesenior.aplicativo.screens.DetalhesCursoScreen
import br.com.montesenior.aplicativo.screens.EsqueceuSuaSenhaScreen
import br.com.montesenior.aplicativo.screens.LoginScreen
import br.com.montesenior.aplicativo.screens.MenuCursoScreen
import br.com.montesenior.aplicativo.screens.MenuCursoScreenViewModel
import br.com.montesenior.aplicativo.screens.NovidadesScreen
import br.com.montesenior.aplicativo.screens.PerfilScreen
import br.com.montesenior.aplicativo.screens.VideoAulaScreen
import br.com.montesenior.aplicativo.ui.theme.AplicativoTheme
import br.com.montesenior.aplicativo.viewmodel.UsuarioViewModel
import com.br.montesenior.aplicativo_porto.screens.RegistroScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AplicativoTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val usuarioViewModel: UsuarioViewModel = viewModel()
                val usuarioLogado by usuarioViewModel.usuarioLogado.collectAsState()
                Scaffold(
                    bottomBar = {
                        if (currentRoute == "cursos" || currentRoute == "perfil" ||
                            currentRoute == "novidades" || currentRoute == "detalhes"
                        ) {
                            NavBar(navController = navController)
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = "boas-vindas",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(route = "boas-vindas") {
                                BoasVindasScreen(navController = navController)
                            }
                            composable(route = "registro") {
                                RegistroScreen(navController = navController)
                            }
                            composable(route = "completar-registro/{nome}/{email}/{telefone}/{genero}") {
                                val nome = it.arguments?.getString("nome") ?: ""
                                val email = it.arguments?.getString("email") ?: ""
                                val telefone = it.arguments?.getString("telefone") ?: ""
                                val genero = it.arguments?.getString("genero") ?: ""
                                CompletarRegistroScreen(nome, email, telefone, genero, navController)
                            }
                            composable(route = "login") {
                                LoginScreen(
                                    navController = navController,
                                    onLoginSuccess = { usuarioId ->
                                        usuarioViewModel.loginUsuario(usuarioId)
                                    }
                                )
                            }
                            composable(route = "esqueceu-a-senha") {
                                EsqueceuSuaSenhaScreen(navController = navController)
                            }
                            composable(route = "cursos") {
                                CursosScreen(
                                    navController = navController
                                )
                            }
                            composable(route = "cursos/detalhes/{cursoId}") { backStackEntry ->
                                val cursoId = backStackEntry.arguments?.getString("cursoId")
                                    ?: return@composable
                                DetalhesCursoScreen(
                                    navController = navController,
                                    cursoId = cursoId
                                )
                            }
                            composable(route = "cursos/{cursoId}") { backStackEntry ->
                                val cursoId = backStackEntry.arguments?.getString("cursoId")
                                    ?: return@composable
                                MenuCursoScreen(
                                    cursoId = cursoId,
                                    navController = navController
                                )
                            }
                            composable(route = "perfil") {
                                if (usuarioLogado != null) {
                                    PerfilScreen(usuario = usuarioLogado!!)
                                } else {
                                    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.Center) {
                                        CircularProgressIndicator()
                                    }
                                }
                            }
                            composable(route = "novidades") {
                                NovidadesScreen()
                            }
                            composable(route = "video-aula/{tarefaId}") { backStackEntry ->
                                val tarefaId = backStackEntry.arguments?.getString("tarefaId")
                                    ?: return@composable
                                VideoAulaScreen(
                                    videoAulaId = tarefaId,
                                    navController = navController
                                )
                            }
                            val cursoViewModel = MenuCursoScreenViewModel()
                            composable("quiz/{tarefaId}") { backStackEntry ->
                                val tarefaId = backStackEntry.arguments?.getString("tarefaId")
                                    ?: return@composable
                                QuizScreen(
                                    onQuizCompleted = {
//                                        cursoViewModel.marcarTarefaComoConcluida(atividadeId, tarefaId)
                                    },
                                    navController = navController,
                                    viewModel = viewModel(),
                                    tarefaId = tarefaId
                                )
                            }
                            composable("leitura-conteudo/{materialId}") { backStackEntry ->
                                val materialId = backStackEntry.arguments?.getString("materialId")
                                    ?: return@composable
                                LeituraConteudoScreen(
                                    materialId = materialId,
                                    navController = navController
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
// uid como email

// trilha no perfil
// formacao de cuidador familiar
// chatbot
// email, telefone, genero, profissional familiar
// carteirinhas, certificado, oportunidade, eventos
// banco de dados
// somente navegacao

// onclick abre duas vezes cada tela