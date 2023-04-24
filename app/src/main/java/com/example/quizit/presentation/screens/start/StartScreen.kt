package com.example.quizit.presentation.screens.start

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import com.example.quizit.domain.util.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.ui.theme.AccentGreen
import com.example.quizit.ui.theme.GreyBG

@Composable
fun StartScreen(
    navController: NavController
) {


    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        Text(
            text = "You will have",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(0.dp, 50.dp, 0.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "${Settings.limit} - ${Settings.difficulty}",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "questions",
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        )

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 100.dp, 0.dp, 0.dp)
        )

        {
            OutlinedButton(
                onClick = { navController.navigate(Screen.QuizScreen.route) },
                border = BorderStroke(2.dp, AccentGreen),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreyBG,
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                shape = RoundedCornerShape(25),
                modifier = Modifier
                    .width(width = 160.dp)
                    .height(height = 80.dp)
            ) {
                Text(text = "Start", fontSize = 30.sp)
            }
        }

        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding(0.dp, 30.dp, 0.dp, 0.dp)
        ) {

            OutlinedButton(
                modifier = Modifier
                    .width(width = 160.dp)
                    .height(height = 80.dp),
                onClick = { navController.navigate(Screen.SettingsScreen.route) },
                border = BorderStroke(2.dp, AccentGreen),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreyBG,
                    contentColor = androidx.compose.ui.graphics.Color.White
                ),
                shape = RoundedCornerShape(25),
            ) {
                Text(text = "Settings", fontSize = 30.sp)
            }

        }
    }
}








