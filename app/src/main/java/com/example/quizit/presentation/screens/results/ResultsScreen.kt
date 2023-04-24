package com.example.quizit.presentation.screens.results

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.MaterialTheme
import androidx.compose.material.OutlinedButton
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color.Companion.White
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import coil.compose.AsyncImage
import com.example.quizit.utils.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.ui.theme.AccentGreen
import com.example.quizit.ui.theme.GreyBG

@Composable
fun ResultsScreen(
    navController: NavController
) {
    Column(
        modifier = Modifier
            .fillMaxSize()

    ) {
        Text(
            text = "Result",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(15.dp, 50.dp, 0.dp, 0.dp)
                .align(Alignment.CenterHorizontally)
        )
        Text(
            text = "Hey Congratulations!",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(0.dp, 50.dp, 0.dp, 80.dp)
                .align(Alignment.CenterHorizontally)
        )
        AsyncImage(
            model = "https://cdn.pixabay.com/photo/2017/01/28/11/43/cup-2015198_1280.png",
            contentDescription = "Trophy",
         //   modifier = Modifier
            //      .align(Alignment.CenterHorizontally)
        )

        Text(
            text = Settings.name,
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.h4,
            modifier = Modifier
                .padding(0.dp, 40.dp, 0.dp, 50.dp)
                .align(Alignment.CenterHorizontally)
        )
        OutlinedButton(
            onClick = { navController.navigate(Screen.SettingsScreen.route) },
            border = BorderStroke(2.dp, AccentGreen),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = GreyBG,
                contentColor = White
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
                .width(width = 300.dp)
                .height(height = 70.dp)
                ){
            Text(text = "Finish")
        }

    }

}