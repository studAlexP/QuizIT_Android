package com.example.quizit.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.quizit.presentation.screens.results.ResultsScreen
import com.example.quizit.presentation.screens.categories.CategoriesScreen
import com.example.quizit.presentation.screens.home.HomeScreen
import com.example.quizit.presentation.screens.quiz.QuizScreen
import com.example.quizit.presentation.screens.settings.SettingsScreen
import com.example.quizit.presentation.screens.start.StartScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = Screen.HomeScreen.route
    ) {
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController = navController)
        }

        composable(route = Screen.SettingsScreen.route) {
            SettingsScreen(navController = navController)
        }

        composable(route = Screen.StartScreen.route) {
            StartScreen(navController = navController)
        }

        composable(route = Screen.CategoriesScreen.route) {
            CategoriesScreen(navController = navController)
        }

        composable(route = Screen.QuizScreen.route) {
            QuizScreen(navController = navController)
        }

        composable(route = Screen.ResultsScreen.route ) {
           ResultsScreen(navController = navController)
        }
    }
}
