package com.example.quizit.presentation.screens.quiz

import androidx.compose.runtime.*
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quizit.utils.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.presentation.viewmodel.QuizViewModel
import com.example.quizit.presentation.widget.DisplayQuestion
import com.example.quizit.presentation.widget.LoadingAnimation

@Composable
fun QuizScreen(
    navController: NavController
) {

    val quizViewModel = viewModel<QuizViewModel>()
    val questions = quizViewModel.questions.collectAsState()

    LaunchedEffect(Unit) {
        quizViewModel.getQuestions(
            Settings.category,
            Settings.difficulty,
            Settings.limit
        )
    }

    if (questions.value == null) {
        LoadingAnimation()
    } else {
        DisplayQuestion(quiz = questions.value!!) {
            navController.navigate(Screen.ResultsScreen.route)
        }
    }
}








