package com.example.quizit.presentation.screens.settings

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizit.utils.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.ui.theme.AccentGreen
import com.example.quizit.ui.theme.GreyBG

@Composable
fun SettingsScreen(
    navController: NavController
) {
    Row {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ) {
            Text(
                text = "Settings",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .align(Alignment.CenterHorizontally)
            )
        }
    }

    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .fillMaxWidth()
            .padding(30.dp, 160.dp)
    ) {
        OutlinedButton(
            onClick = { navController.navigate(Screen.CategoriesScreen.route) },
            border = BorderStroke(2.dp, AccentGreen),
            elevation = ButtonDefaults.elevation(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = GreyBG,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .width(width = 150.dp)
                .height(height = 150.dp)
        ) {
            Text(
                text = "Categories",
                style = MaterialTheme.typography.h5

            )
        }

        OutlinedButton(
            onClick = { navController.navigate(Screen.StartScreen.route) },
            border = BorderStroke(2.dp, AccentGreen),
            elevation = ButtonDefaults.elevation(10.dp),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = GreyBG,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(20),
            modifier = Modifier
                .width(width = 150.dp)
                .height(height = 150.dp)
        ) {
            Text(
                text = "Random",
                style = MaterialTheme.typography.h5

            )
        }
    }

    Box(modifier = Modifier.padding(30.dp, 400.dp, 30.dp, 50.dp)) {
        Text(
            text = "Questions:",
            style = MaterialTheme.typography.h6


        )
    }

    Box(
        modifier = Modifier.padding(30.dp, 420.dp, 30.dp, 0.dp)
    ) {
        QuestionsSlider()
    }

    Box(modifier = Modifier.padding(30.dp, 500.dp, 30.dp, 50.dp)) {
        Text(
            text = "Difficulty:",
            style = MaterialTheme.typography.h6


        )
    }

    Box(
        modifier = Modifier.padding(30.dp, 520.dp, 30.dp, 0.dp)
    ) {
        DifficultySlider()
    }


}

@Composable
fun QuestionsSlider() {
    var sliderPosition by remember { mutableStateOf(10f) }

    Settings.limit = sliderPosition.toInt().toString()


    Text(
        text = Settings.limit,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(5.dp, 30.dp, 0.dp, 20.dp)
    )



    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 5f..20f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
        steps = 2,
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = AccentGreen
        ),
    )

}

@Composable
fun DifficultySlider() {
    var sliderPosition by remember { mutableStateOf(1f) }

    when(sliderPosition.toInt()){
        1 -> Settings.difficulty = "Easy"
        2 -> Settings.difficulty = "Medium"
        3 -> Settings.difficulty = "Hard"
    }

    Text(
        text = Settings.difficulty,
        style = MaterialTheme.typography.h6,
        modifier = Modifier.padding(5.dp, 30.dp, 0.dp, 20.dp)
    )

    Slider(
        value = sliderPosition,
        onValueChange = { sliderPosition = it },
        valueRange = 1f..3f,
        onValueChangeFinished = {
            // launch some business logic update with the state you hold
            // viewModel.updateSelectedSliderValue(sliderPosition)
        },
        steps = 1,
        colors = SliderDefaults.colors(
            thumbColor = Color.White,
            activeTrackColor = AccentGreen
        ),
    )

}
