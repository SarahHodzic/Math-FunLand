package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme

import android.app.Activity
import android.content.Intent
import android.content.res.Configuration
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Share
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Button
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.MaterialTheme.shapes
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.R



@Composable
fun GameScreen(
    gameViewModel: GameViewModel = viewModel(),
    navController: NavController
) {
   // val viewModel: GameViewModel= viewModel()
    val gameUiState by gameViewModel.uiState.collectAsState()
    val totalScore = gameUiState.score
    val configuration = LocalConfiguration.current
    val correctMessage = stringResource(id = R.string.correct)
    val incorrectMessage = stringResource(id = R.string.message_incorrect)
    val timeoutMessage = stringResource(id = R.string.message_timeout)


    Scaffold(
        topBar = {
            TopAppBar(
                score = totalScore,
                navController = navController,
                gameViewModel = gameViewModel
            )
        }
    ){innerpadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerpadding),
            contentAlignment = Alignment.Center
        ) {
            if (configuration.orientation == Configuration.ORIENTATION_PORTRAIT) {

                Column(
                    modifier = Modifier
                        .fillMaxSize(),
                    verticalArrangement = Arrangement.Center,
                    horizontalAlignment = Alignment.CenterHorizontally,

                    ) {
                        Spacer(modifier = Modifier.padding(innerpadding))
            
                    Text(
                        text = stringResource(id = R.string.timer, gameUiState.timeLeft)
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Card {
                        Text(
                            text = "${gameUiState.number1} ${gameUiState.operation} ${gameUiState.number2}",
                            modifier = Modifier.padding(16.dp)
                        )
                    }

                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    OutlinedTextField(
                        value = gameViewModel.userGuess,
                        singleLine = true,
                        shape = shapes.large,
                        onValueChange = { gameViewModel.updateAnswer(it) },
                        label = { Text(text = stringResource(id = R.string.your_answer)) },
                        keyboardOptions = KeyboardOptions.Default.copy(
                            keyboardType = KeyboardType.Number,
                            imeAction = ImeAction.Done
                        ),
                        keyboardActions = KeyboardActions(
                            onDone = { gameViewModel.checkAnswer(correctMessage,incorrectMessage) }
                        )
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Button(
                        onClick = { gameViewModel.checkAnswer(correctMessage,incorrectMessage) },
                        enabled = gameViewModel.userGuess.isNotEmpty()
                    ) {
                        Text(
                            text = stringResource(id = R.string.submit)
                        )
                    }
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )
                    Text(
                        text = stringResource(id = R.string.score1, totalScore)
                    )
                    Spacer(
                        modifier = Modifier.height(16.dp)
                    )

                }
            }
            else{
                LanscapeMode(
                    innerpadding = innerpadding,
                    gameViewModel = gameViewModel,
                    gameUiState = gameUiState,
                    totalScore = totalScore,
                    correctMessage = correctMessage,
                    incorrectMessage = incorrectMessage
                )
            }
        }
        if (gameUiState.isAnswerWrong || gameUiState.timeLeft == 0) {
            EndGameDialog(
                score = totalScore,
                onPlayAgain = {

                    gameViewModel.resetGame()
                    gameViewModel.startGame(timeoutMessage)},
                message = gameUiState.message
            )
        }

        if (gameUiState.isAnswerRight) {
            CorrectAnsDialog(
                onPlayAgain = { gameViewModel.onNextClick(timeoutMessage) },
            )
        }

    }

}

@Composable
fun LanscapeMode(innerpadding: PaddingValues,
                 gameViewModel: GameViewModel,
                 gameUiState: GameUiState,
                 totalScore: Int,
                 correctMessage: String,
                 incorrectMessage: String,
                 modifier: Modifier = Modifier){
    Box(
        modifier = Modifier
            .fillMaxSize()
            .padding(innerpadding),
        contentAlignment = Alignment.Center
    ) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            ,
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,

        ) {


        Card {
            Text(
                text = "${gameUiState.number1} ${gameUiState.operation} ${gameUiState.number2}",
                modifier = Modifier.padding(16.dp)
            )
        }
        Spacer(
            modifier = Modifier.height(16.dp)
        )
        Row(
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            Text(
                text = stringResource(id = R.string.timer, gameUiState.timeLeft),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            OutlinedTextField(
                value = gameViewModel.userGuess,
                singleLine = true,
                shape = shapes.large,
                onValueChange = { gameViewModel.updateAnswer(it) },
                label = { Text(text = stringResource(id = R.string.your_answer)) },
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                keyboardActions = KeyboardActions(
                    onDone = { gameViewModel.checkAnswer(correctMessage,incorrectMessage) }
                ),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )
            Text(
                text = stringResource(id = R.string.score1, totalScore),
                modifier = Modifier.align(Alignment.CenterVertically)
            )
            Spacer(
                modifier = Modifier.height(16.dp)
            )

        }


        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Button(
            onClick = { gameViewModel.checkAnswer(correctMessage,incorrectMessage) },
            enabled = gameViewModel.userGuess.isNotEmpty()
        ) {
            Text(
                text = stringResource(id = R.string.submit)
            )
        }

    }
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopAppBar(score: Int, modifier: Modifier = Modifier,navController:NavController,gameViewModel: GameViewModel){
    val context = LocalContext.current
    val score1 = stringResource(id = R.string.you_scored , score)
    TopAppBar(
        navigationIcon = {
            IconButton(onClick = {
                gameViewModel.stopTimer()
                navController.navigateUp() }) {
                Icon(
                    imageVector = Icons.Filled.ArrowBack,
                    contentDescription = stringResource(R.string.back_button),
                    tint = Color.White
                )
            } },
        title = { Text(
            text = stringResource(id = R.string.game_name),
            color = Color.White
            ) },
        actions = {
            IconButton(onClick = {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,score1
                    )
                    type = "text/plain"
                }
                context.startActivity(
                    Intent.createChooser(
                        intent,
                        context.getString(R.string.score)
                    )
                )

            }) {
                Icon(
                    Icons.Default.Share,
                    contentDescription = stringResource(id = R.string.share),
                    tint = Color.White)
            }
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = MaterialTheme.colorScheme.primary
        )
    )
}

@Composable
private fun CorrectAnsDialog(
    onPlayAgain: () -> Unit,
    modifier: Modifier = Modifier
) {

    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = stringResource(id = R.string.correct)) },

        modifier = modifier,
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = stringResource(R.string.next_question))
            }

        }
    )
}

@Composable
private fun EndGameDialog(
    score: Int,
    onPlayAgain: () -> Unit,
    message: String,
    modifier: Modifier = Modifier
) {
    val activity = (LocalContext.current as Activity)
    val context = LocalContext.current
    val score1 = stringResource(id = R.string.you_scored , score)
    AlertDialog(
        onDismissRequest = {},
        title = { Text(text = message) },
        text = { Text(text = stringResource(R.string.score1, score)) },
        modifier = modifier,
        dismissButton = {
            TextButton(
                onClick = {
                    activity.finish()
                }
            ) {
                Text(text = stringResource(R.string.exit))
            }
        },
        confirmButton = {
            TextButton(onClick = onPlayAgain) {
                Text(text = stringResource(R.string.play_again))
            }
            IconButton(onClick = {
                val intent = Intent().apply {
                    action = Intent.ACTION_SEND
                    putExtra(
                        Intent.EXTRA_TEXT,score1
                    )
                    type = "text/plain"
                }
                context.startActivity(
                    Intent.createChooser(
                        intent,
                        context.getString(R.string.score)
                    )
                )

            }) {
                Icon(Icons.Default.Share, contentDescription = "Share")
            }
        }
    )
}
