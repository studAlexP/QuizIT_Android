package com.example.quizit.presentation.screens.quiz

import android.app.Activity
import androidx.compose.runtime.*
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.quizit.di.QuizViewModelFactoryProvider
import com.example.quizit.domain.util.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.presentation.viewmodel.QuizViewModel
import com.example.quizit.presentation.widget.DisplayQuestion
import com.example.quizit.presentation.widget.LoadingAnimation
import dagger.hilt.android.EntryPointAccessors

@Composable
fun QuizScreen(
    navController: NavController
) {
    val factory = EntryPointAccessors.fromActivity(
        LocalContext.current as Activity,
        QuizViewModelFactoryProvider::class.java
    ).quizViewModelFactory()

    val viewModel: QuizViewModel = viewModel(
        factory = QuizViewModel.provideQuizViewModelFactory(
            factory = factory,
            category = Settings.category,
            difficulty = Settings.difficulty,
            limit = Settings.limit
        )
    )

    val questions = viewModel.questions.collectAsState()

    if (questions.value == null) {
        LoadingAnimation()
    } else {
        DisplayQuestion(quiz = questions.value!!) {
            navController.navigate(Screen.ResultsScreen.route)
        }
    }
}








