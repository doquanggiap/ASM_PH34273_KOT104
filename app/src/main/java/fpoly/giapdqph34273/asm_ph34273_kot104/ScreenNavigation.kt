package fpoly.giapdqph34273.asm_ph34273_kot104

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController

@Composable
fun ScreenNavigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.Boarding.route,
    ) {
        composable(Screen.Boarding.route) { Boarding(navController) }
        composable(Screen.Login.route) { Login(navController) }
        composable(Screen.SignUp.route) { SignUp(navController) }
        composable(Screen.MyBottombar.route) { MyBottombar(navController) }
        composable(Screen.Home.route) { Home(navController) }
        composable(Screen.ProductDetail.route) { ProductDetail(navController) }
        composable(Screen.Cart.route) { Cart(navController) }
        composable(Screen.CheckOut.route) { CheckOut(navController) }
        composable(Screen.Congrats.route) { Congrats(navController) }
    }
}