package br.com.montesenior.aplicativo

import CursosScreen
import QuizScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.montesenior.aplicativo.components.NavBar
import br.com.montesenior.aplicativo.model.usuarioMock
import br.com.montesenior.aplicativo.repository.cursoCuidador
import br.com.montesenior.aplicativo.repository.cursoEtarismo
import br.com.montesenior.aplicativo.screens.BoasVindasScreen
import br.com.montesenior.aplicativo.screens.DetalhesCursoScreen
import br.com.montesenior.aplicativo.screens.EsqueceuSuaSenhaScreen
import br.com.montesenior.aplicativo.screens.LoginScreen
import br.com.montesenior.aplicativo.screens.MenuCursoScreen
import br.com.montesenior.aplicativo.screens.MenuCursoScreenViewModel
import br.com.montesenior.aplicativo.screens.NovidadesScreen
import br.com.montesenior.aplicativo.screens.PerfilScreen
import br.com.montesenior.aplicativo.screens.VideoAulaScreen
import br.com.montesenior.aplicativo.ui.theme.AplicativoTheme
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
                            startDestination = "novidades",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(route = "boas-vindas") {
                                BoasVindasScreen(navController = navController)
                            }
                            composable(route = "registro") {
                                RegistroScreen(navController = navController)
                            }
                            composable(route = "login") {
                                LoginScreen(
                                    navController = navController
                                )
                            }
                            composable(route = "esqueceu-a-senha") {
                                EsqueceuSuaSenhaScreen(navController = navController)
                            }
                            composable(route = "cursos") {
                                CursosScreen(
                                    modifier = Modifier.fillMaxSize(),
                                    navController = navController
                                )
                            }
                            composable(route = "detalhes-curso-cuidador") {
                                DetalhesCursoScreen(
                                    navController = navController,
                                    curso = cursoCuidador
                                )
                            }
                            composable(route = "detalhes-curso-etarismo") {
                                DetalhesCursoScreen(
                                    navController = navController,
                                    curso = cursoEtarismo
                                )
                            }
                            composable(route = "perfil") {
                                PerfilScreen(usuario = usuarioMock)
                            }
                            composable(route = "novidades") {
                                NovidadesScreen()
                            }
                            composable(route = "menu-curso-cuidador") {
                                MenuCursoScreen(
                                    cursoItem = cursoCuidador,
                                    navController = navController
                                )
                            }
                            composable(route = "menu-curso-etarismo") {
                                MenuCursoScreen(
                                    cursoItem = cursoEtarismo,
                                    navController = navController
                                )
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
                        }
                    }
                }
            }
        }
    }
}
// trilha no perfil
// formacao de cuidador familiar
// chatbot
// email, telefone, genero, profissional familiar
// carteirinhas, certificado, oportunidade, eventos
// banco de dados
// somente navegacao

// onclick abre duas vezes cada tela