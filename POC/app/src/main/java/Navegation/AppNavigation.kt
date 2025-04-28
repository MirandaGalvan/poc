package Navegation
import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import login.ui.LoginScreen
import login.ui.LoginViewModel
import formulario.FormularioScreen

@Composable
fun AppNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = AppScreens.LoginScreen.route
    ) {
        composable(route = AppScreens.LoginScreen.route) {
            // Aquí deberás proporcionar una instancia de LoginViewModel
            LoginScreen(LoginViewModel(), navController)
        }

        composable(route = AppScreens.FormularioScreen.route) {
            FormularioScreen(navController)
        }
    }
}