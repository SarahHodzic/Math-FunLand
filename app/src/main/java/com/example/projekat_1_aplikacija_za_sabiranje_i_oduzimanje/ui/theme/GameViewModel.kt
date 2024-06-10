package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme

import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import kotlin.random.Random

class GameViewModel: ViewModel(){
    private val _uiState = MutableStateFlow(GameUiState())
    val uiState: StateFlow<GameUiState> = _uiState.asStateFlow()

    var userGuess by mutableStateOf("")
        private set

    private var timerJob: Job? = null

    init {
        resetGame()

    }


    fun resetGame(){
        _uiState.update { currenState ->
            currenState.copy(
                score = 0,
                isAnswerWrong = false,
                isAnswerRight = false
            )
        }
        generatingNumbersAndOperations()
        userGuess = ""
        //startTimer()
    }


    private fun generatingNumbersAndOperations(){
        val operation = if (Random.nextBoolean()) "+" else "-"
        _uiState.update { currentState ->
            currentState.copy(
                number1 = Random.nextInt(1,10),
                number2 = Random.nextInt(1,10),
                operation = operation,
                timeLeft = 10,
                message = "",

            )
        }
    }
    private fun startTimer(timeoutMessage: String) {
        timerJob?.cancel()
        timerJob = viewModelScope.launch {
            while (_uiState.value.timeLeft > 0 && !_uiState.value.isAnswerWrong && !_uiState.value.isAnswerRight) {
                delay(1000L)
                _uiState.update { currentState ->
                    currentState.copy(
                        timeLeft = _uiState.value.timeLeft - 1
                    )
                }
            }
            if (_uiState.value.timeLeft == 0) {
                _uiState.update { currentState ->
                    currentState.copy(
                        message = timeoutMessage
                    )
                }
            }
        }

    }

    fun startGame(timeoutMessage: String){
        resetGame()
        startTimer(timeoutMessage)
    }

    fun stopTimer(){
        timerJob?.cancel()
        timerJob = null
        resetGame()
    }

    fun onNextClick(timeoutMessage: String) {
        _uiState.update { currentState ->
            currentState.copy(
                isAnswerRight = false
            )
        }
        generatingNumbersAndOperations()
        startTimer(timeoutMessage)
        userGuess = ""
    }

    fun updateAnswer(guessedWord: String){
        userGuess = guessedWord
    }

    fun checkAnswer(correctMessage: String, incorrectMesage: String){
        val correctAnswer = when (_uiState.value.operation) {
            "+" -> _uiState.value.number1 + _uiState.value.number2
            "-" -> _uiState.value.number1 - _uiState.value.number2
            else -> 0
        }

        if (userGuess.toIntOrNull() == correctAnswer){
            _uiState.update { currentState ->
                currentState.copy(
                    score = _uiState.value.score + 1,
                    message = correctMessage,
                    isAnswerRight = true,
                    isAnswerWrong = false
                )
            }
        }
        else{
            _uiState.update { currentState ->
                currentState.copy(
                    message = incorrectMesage,
                    isAnswerWrong = true,
                    isAnswerRight = false
                )
            }
        }
        userGuess = ""

    }
}