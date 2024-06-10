package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme

import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

import com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.R

@Composable
fun LandingPage(navController: NavController,gameViewModel: GameViewModel, modifier: Modifier = Modifier) {
    val timeoutMessage = stringResource(id = R.string.message_timeout)
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Text(
            text = stringResource(id = R.string.welcome),
            style = MaterialTheme.typography.headlineLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text =  stringResource(id = R.string.info),
            style = MaterialTheme.typography.bodyLarge,
            textAlign = TextAlign.Center
        )
        Spacer(modifier = Modifier.height(32.dp))
        Button(onClick = {
            gameViewModel.startGame(timeoutMessage)
            navController.navigate(MathGameScreen.Game.name) }) {
            Text(text = stringResource(id = R.string.start_game))
        }
    }
}
