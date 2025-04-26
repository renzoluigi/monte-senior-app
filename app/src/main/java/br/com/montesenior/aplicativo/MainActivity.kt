package br.com.montesenior.aplicativo

import MaterialScreen
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import br.com.montesenior.aplicativo.components.NavBar
import br.com.montesenior.aplicativo.screens.BoasVindasScreen
import br.com.montesenior.aplicativo.screens.DetalhesCursoScreen
import br.com.montesenior.aplicativo.screens.EsqueceuSuaSenhaScreen
import br.com.montesenior.aplicativo.screens.LoginScreen
import br.com.montesenior.aplicativo.screens.LoginScreenViewModel
import br.com.montesenior.aplicativo.screens.PerfilScreen
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
                        if (currentRoute == "cursos" || currentRoute == "perfil" || currentRoute == "novidades" || currentRoute == "detalhes") {
                            NavBar(navController = navController)
                        }
                    },
                    modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Surface(modifier = Modifier.fillMaxSize()) {
                        NavHost(
                            navController = navController,
                            startDestination = "boasvindas",
                            modifier = Modifier.padding(innerPadding)
                        ) {
                            composable(route = "boasvindas") {
                                BoasVindasScreen(navController = navController)
                            }
                            composable(route = "registro") {
                                RegistroScreen()
                            }
                            composable(route = "login") {
                                LoginScreen(
                                    navController = navController,
                                    modifier = Modifier.fillMaxSize(),
                                    loginScreenViewModel = LoginScreenViewModel()
                                )
                            }
                            composable(route = "esqueceuasenha") {
                                EsqueceuSuaSenhaScreen()
                            }
                            composable(route = "cursos") {
                                MaterialScreen(modifier = Modifier.fillMaxSize(), navController = navController)
                            }
                            composable(route = "perfil") {
                                PerfilScreen()
                            }
                            composable(route = "novidades") {
                                Text("Tela de Novidades")
                            }
                            composable(route = "detalhes") {
                                DetalhesCursoScreen(navController = navController)
                            }
                        }
                    }
                }
            }
        }
    }
}

// mostrar para o luckas variacoes da cor de fonte em loginscreen e registroscreen (cozyblue nos titulos)
// ajeitar perfilscreen com arrangement e alignment center
