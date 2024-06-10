package com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme.GameScreen
import com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme.MathGame
import com.example.projekat_1_aplikacija_za_sabiranje_i_oduzimanje.ui.theme.Projekat_1_Aplikacija_za_sabiranje_i_oduzimanjeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Projekat_1_Aplikacija_za_sabiranje_i_oduzimanjeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    MathGame()
                }
            }
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Projekat_1_Aplikacija_za_sabiranje_i_oduzimanjeTheme {

    }
}