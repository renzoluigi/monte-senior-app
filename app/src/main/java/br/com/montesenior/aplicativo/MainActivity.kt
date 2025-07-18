package br.com.montesenior.aplicativo

import CursosScreen
import QuizScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.animation.core.tween
import androidx.compose.animation.fadeIn
import androidx.compose.animation.fadeOut
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Scaffold
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
import br.com.montesenior.aplicativo.screens.authentication.BoasVindasScreen
import br.com.montesenior.aplicativo.screens.authentication.CompletarRegistroScreen
import br.com.montesenior.aplicativo.screens.authentication.EnviarImagemScreen
import br.com.montesenior.aplicativo.screens.authentication.EsqueceuSuaSenhaScreen
import br.com.montesenior.aplicativo.screens.authentication.LoginScreen
import br.com.montesenior.aplicativo.screens.course.LeituraConteudoScreen
import br.com.montesenior.aplicativo.screens.course.MenuCursoScreen
import br.com.montesenior.aplicativo.screens.course.VideoAulaScreen
import br.com.montesenior.aplicativo.screens.menu.DetalhesCursoScreen
import br.com.montesenior.aplicativo.screens.menu.EditarPerfilScreen
import br.com.montesenior.aplicativo.screens.menu.NovidadesScreen
import br.com.montesenior.aplicativo.screens.menu.PerfilScreen
import br.com.montesenior.aplicativo.ui.theme.AplicativoTheme
import br.com.montesenior.aplicativo.viewmodel.UsuarioViewModel
import com.br.montesenior.aplicativo_porto.screens.RegistroScreen
import com.google.firebase.FirebaseApp
import java.net.URLDecoder
import java.nio.charset.StandardCharsets

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        FirebaseApp.initializeApp(this)
        enableEdgeToEdge()
        setContent {
            AplicativoTheme {
                val navController = rememberNavController()
                val navBackStackEntry by navController.currentBackStackEntryAsState()
                val currentRoute = navBackStackEntry?.destination?.route
                val usuarioViewModel: UsuarioViewModel = viewModel()
                val usuarioLogado by usuarioViewModel.usuarioLogado.collectAsState()
                val usuarioLogadoId by usuarioViewModel.usuarioLogadoId.collectAsState()
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
                    NavHost(
                        navController = navController,
                        startDestination = "boas-vindas",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable(
                            route = "boas-vindas",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }
                        ) {
                            BoasVindasScreen(navController = navController)
                        }
                        composable(
                            route = "registro",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) {
                            RegistroScreen(navController = navController)
                        }
                        composable(
                            route = "enviar-imagem/{nome}/{email}/{telefone}/{genero}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) { backStackEntry ->
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""
                            val email = backStackEntry.arguments?.getString("email") ?: ""
                            val telefone = backStackEntry.arguments?.getString("telefone") ?: ""
                            val genero = backStackEntry.arguments?.getString("genero") ?: ""
                            EnviarImagemScreen(nome, email, telefone, genero, navController)
                        }
                        composable(
                            route = "completar-registro/{nome}/{email}/{telefone}/{genero}/{urlCodificado}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) { backStackEntry ->
                            val nome = backStackEntry.arguments?.getString("nome") ?: ""
                            val email = backStackEntry.arguments?.getString("email") ?: ""
                            val telefone = backStackEntry.arguments?.getString("telefone") ?: ""
                            val genero = backStackEntry.arguments?.getString("genero") ?: ""
                            val urlCodificado =
                                backStackEntry.arguments?.getString("urlCodificado") ?: ""
                            val urlDecodificado = URLDecoder.decode(
                                urlCodificado,
                                StandardCharsets.UTF_8.toString()
                            )
                            CompletarRegistroScreen(
                                nome,
                                email,
                                telefone,
                                genero,
                                urlDecodificado,
                                navController
                            )
                        }
                        composable(
                            route = "login",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) {
                            LoginScreen(
                                navController = navController,
                                onLoginSuccess = { usuarioId ->
                                    usuarioViewModel.loginUsuario(usuarioId)
                                }
                            )
                        }
                        composable(
                            route = "esqueceu-a-senha",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) {
                            EsqueceuSuaSenhaScreen(navController = navController)
                        }
                        composable(
                            route = "cursos",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) {
                            CursosScreen(
                                navController = navController
                            )
                        }
                        composable(
                            route = "cursos/detalhes/{cursoId}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) },
                        ) { backStackEntry ->
                            val cursoId = backStackEntry.arguments?.getString("cursoId")
                                ?: return@composable
                            if (usuarioLogadoId != null) {
                                DetalhesCursoScreen(
                                    navController = navController,
                                    cursoId = cursoId,
                                    usuarioId = usuarioLogadoId!!
                                )
                            } else {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                        composable(
                            route = "perfil",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }
                        ) {
                            if (usuarioLogado != null) {
                                PerfilScreen(
                                    usuario = usuarioLogado!!,
                                    navController = navController
                                )
                            } else {
                                Box(
                                    modifier = Modifier.fillMaxSize(),
                                    contentAlignment = Alignment.Center
                                ) {
                                    CircularProgressIndicator()
                                }
                            }
                        }
                        composable(
                            route = "editar-perfil",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }
                        ) {
                            EditarPerfilScreen(
                                usuario = usuarioLogado!!,
                                onSalvarClick = { navController.navigate("perfil") },
                                onVoltarClick = { navController.navigate("perfil") })
                        }
                        composable(
                            route = "novidades",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }
                        ) {
                            NovidadesScreen(navController = navController)
                        }
                        composable(
                            route = "cursos/{cursoId}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }) { backStackEntry ->
                            val cursoId = backStackEntry.arguments?.getString("cursoId")
                                ?: return@composable
                            MenuCursoScreen(
                                cursoId = cursoId,
                                navController = navController,
                                usuario = usuarioLogado!!,
                                uid = usuarioLogadoId!!
                            )
                        }
                        composable(
                            "{cursoId}/{moduloId}/leitura-conteudo/{materialId}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }) { backStackEntry ->
                            val cursoId = backStackEntry.arguments?.getString("cursoId")
                                ?: return@composable
                            val moduloId = backStackEntry.arguments?.getString("moduloId")
                                ?: return@composable
                            val materialId = backStackEntry.arguments?.getString("materialId")
                                ?: return@composable
                            LeituraConteudoScreen(
                                uid = usuarioLogadoId!!,
                                cursoId = cursoId,
                                moduloId = moduloId,
                                tarefaId = materialId,
                                navController = navController
                            )
                        }
                        composable(
                            route = "{cursoId}/{moduloId}/video-aula/{tarefaId}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }) { backStackEntry ->
                            val cursoId = backStackEntry.arguments?.getString("cursoId")
                                ?: return@composable
                            val moduloId = backStackEntry.arguments?.getString("moduloId")
                                ?: return@composable
                            val tarefaId = backStackEntry.arguments?.getString("tarefaId")
                                ?: return@composable
                            VideoAulaScreen(
                                uid = usuarioLogadoId!!,
                                cursoId = cursoId,
                                tarefaId = tarefaId,
                                moduloId = moduloId,
                                navController = navController
                            )
                        }
                        composable(
                            "{cursoId}/{moduloId}/quiz/{tarefaId}",
                            enterTransition = { fadeIn(animationSpec = tween(300)) },
                            exitTransition = { fadeOut(animationSpec = tween(300)) }) { backStackEntry ->
                            val cursoId = backStackEntry.arguments?.getString("cursoId")
                                ?: return@composable
                            val moduloId = backStackEntry.arguments?.getString("moduloId")
                                ?: return@composable
                            val tarefaId = backStackEntry.arguments?.getString("tarefaId")
                                ?: return@composable
                            QuizScreen(
                                uid = usuarioLogadoId!!,
                                cursoId = cursoId,
                                moduloId = moduloId,
                                tarefaId = tarefaId,
                                navController = navController
                            )
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
// carteirinhas, certificado, oportunidade, eventos

// onclick abre duas vezes cada tela