package com.example.quizit

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material.Surface
import com.example.quizit.presentation.navigation.Navigation
import com.example.quizit.ui.theme.GreyBG
import com.example.quizit.ui.theme.QuizITTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            QuizITTheme{
                Surface(color = GreyBG){
                    Navigation()
                }
            }
        }
    }
}