package br.com.montesenior.aplicativo.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import br.com.montesenior.aplicativo.ui.theme.Poppins

@Composable
fun NavBar(navController: NavController) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentRoute = navBackStackEntry?.destination?.route

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .height(75.dp),
        colors = CardDefaults.cardColors(containerColor = Color.White),
        shape = RectangleShape
    ) {
        Row(modifier = Modifier.fillMaxSize(), horizontalArrangement = Arrangement.SpaceEvenly) {
            NavBarItem(
                label = "Início",
                icon = Icons.Default.Home,
                isSelected = currentRoute == "cursos",
                onClick = {
                    navController.navigate("cursos") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavBarItem(
                label = "Novidades",
                icon = Icons.Default.Notifications,
                isSelected = currentRoute == "novidades",
                onClick = {
                    navController.navigate("novidades") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
            NavBarItem(
                label = "Perfil",
                icon = Icons.Default.AccountCircle,
                isSelected = currentRoute == "perfil",
                onClick = {
                    navController.navigate("perfil") {
                        popUpTo(navController.graph.startDestinationId) {
                            saveState = true
                        }
                        launchSingleTop = true
                        restoreState = true
                    }
                }
            )
        }
    }
}

@Composable
fun NavBarItem(
    label: String,
    icon: androidx.compose.ui.graphics.vector.ImageVector,
    isSelected: Boolean,
    onClick: () -> Unit
) {
    Column(
        modifier = Modifier
            .fillMaxHeight()
            .width(100.dp)
            .clickable(onClick = onClick),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Icon(
            imageVector = icon,
            contentDescription = "Ícone da página $label",
            modifier = Modifier.fillMaxWidth(),
            tint = if (isSelected) Color.Black else Color.Gray
        )
        Text(
            text = label,
            fontSize = if (label == "Novidades") 18.sp else 20.sp,
            color = if (isSelected) Color.Black else Color.Gray
        )
    }
}

//@Preview(showBackground = true, showSystemUi = true)
//@Composable
//private fun NavigationBarPreview() {
//    NavBar()
//}