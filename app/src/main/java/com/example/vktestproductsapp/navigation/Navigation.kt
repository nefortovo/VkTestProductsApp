package com.example.vktestproductsapp.navigation

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import com.example.vktestproductsapp.navigation.Screens.Companion.ID_KEY
import com.example.vktestproductsapp.screens.main.MainScreen
import com.example.vktestproductsapp.screens.product.ProductScreen

@Composable
fun Navigation(modifier: Modifier) {
    val navController = rememberNavController()
    Scaffold(
        modifier = modifier
            .statusBarsPadding()
    ) { padding ->
        NavHost(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .background(Color(0xFFB8B8C8)),
            navController = navController,
            startDestination = Screens.MainScreen.destination()
        ) {

            composable(route = Screens.MainScreen.destination()) {
                MainScreen(modifier = Modifier.fillMaxSize(),
                    navigateToProduct = { navController.navigate(Screens.ProductScreen.destination(it)) }
                )
            }

            composable(
                route = Screens.ProductScreen.screenRoute,
                arguments = listOf(navArgument(ID_KEY) {
                    type = NavType.IntType
                    nullable = false
                })
            ) { navBackStackEntry ->
                val id = navBackStackEntry.arguments?.getInt(ID_KEY)
                ProductScreen(
                    onBack = navController::popBackStack,
                    modifier = Modifier
                        .fillMaxSize(),
                    id = id!!
                )
            }
        }
    }
}

sealed class Screens(
    val screenRoute: String
) {


    object MainScreen : Screens(
        screenRoute = mainScreenRoute,
    ) {
        fun destination(): String {
            return screenRoute
        }
    }

    object ProductScreen : Screens(
        screenRoute = "$productDetailsScreen/{$ID_KEY}",
    ) {
        fun destination(name: Int): String {
            return "$productDetailsScreen/$name"
        }
    }


    companion object {
        const val ID_KEY = "-1"


        const val mainScreenRoute = "mainScreen"
        const val productDetailsScreen = "productDetailsScreen"
    }
}