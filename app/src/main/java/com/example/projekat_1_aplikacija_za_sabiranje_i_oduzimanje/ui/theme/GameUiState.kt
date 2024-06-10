package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme

data class GameUiState (
    val number1: Int = 0,
    val number2: Int = 0,
    val answer: String = "",
    val score: Int = 0,
    val timeLeft: Int = 10,
    val message: String = "",
    val operation: String = "+",
    val isAnswerWrong: Boolean = false,
    val isAnswerRight: Boolean = false,
)