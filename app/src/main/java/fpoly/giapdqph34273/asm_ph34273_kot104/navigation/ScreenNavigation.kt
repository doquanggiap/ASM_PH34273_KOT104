package fpoly.giapdqph34273.asm_ph34273_kot104.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.Boarding
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.Cart
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.CheckOut
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.Congrats
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.Home
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.Login
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.ProductDetail
import fpoly.giapdqph34273.asm_ph34273_kot104.ui.screen.SignUp

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