package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme


import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController


enum class MathGameScreen {
    Landing, Game
}

@Composable
fun MathGame(
    viewModel: GameViewModel = viewModel(),
    navController: NavHostController = rememberNavController()
) {
    // Get current back stack entry
    val backStackEntry by navController.currentBackStackEntryAsState()
    // Get the name of the current screen
    val currentScreen = MathGameScreen.valueOf(
        backStackEntry?.destination?.route ?: MathGameScreen.Landing.name
    )
    //val uiState by viewModel.uiState.collectAsState()

        NavHost(
            navController = navController,
            startDestination = MathGameScreen.Landing.name,
            modifier = Modifier
                .fillMaxSize()
                .verticalScroll(rememberScrollState())
        ) {
            composable(route = MathGameScreen.Landing.name) {
                LandingPage(
                    navController = navController,
                    gameViewModel = viewModel
                   // modifier = Modifier.padding(innerpadding)
                )
            }
            composable(route = MathGameScreen.Game.name) {
                GameScreen(
                    navController = navController,
                    gameViewModel = viewModel,

                )
            }
        }
    }
