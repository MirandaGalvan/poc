package Navegation


sealed class AppScreens(val route: String) {
    object LoginScreen: AppScreens("login_screen")
    object FormularioScreen: AppScreens("formulario_screen")
}