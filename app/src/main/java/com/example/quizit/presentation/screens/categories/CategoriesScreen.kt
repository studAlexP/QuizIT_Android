package com.example.quizit.presentation.screens.categories


import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.presentation.widget.CategoryCard


@Composable
fun CategoriesScreen(
    navController: NavController
){

    Column(
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
    ){
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Pick a category",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .align(Alignment.CenterHorizontally)

            )
        }

        Column(
            modifier = Modifier
                .padding(0.dp, 20.dp)
        ) {
            CategoryCard("Linux") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("Bash") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("Uncategorized") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("Docker") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("SQL") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("CMS") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("Code") { navController.navigate(Screen.StartScreen.route)}
            CategoryCard("DevOps") { navController.navigate(Screen.StartScreen.route)}
        }
    }
}
