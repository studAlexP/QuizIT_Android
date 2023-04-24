package com.example.quizit.presentation.screens.home

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.quizit.domain.util.Settings
import com.example.quizit.presentation.navigation.Screen
import com.example.quizit.ui.theme.AccentGreen
import com.example.quizit.ui.theme.GreyBG


@Composable
fun HomeScreen(
    navController: NavController
){
    Row {
        Column(
            modifier = Modifier
                .fillMaxSize()
        ){
            Text(
                text = "Welcome to QuizIT!",
                fontWeight = FontWeight.Bold,
                style = MaterialTheme.typography.h4,
                modifier = Modifier
                    .padding(0.dp, 50.dp, 0.dp, 0.dp)
                    .align(CenterHorizontally)

            )
        }

    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(0.dp, 300.dp, 10.dp, 10.dp)
    ) {
        Row {
           Text(
               text = "Please enter your name:",
               style = MaterialTheme.typography.h5,
               modifier = Modifier
                   .padding(20.dp, 10.dp, 10.dp, 10.dp)


           )
        }
        Row{
            Row {
                NameFieldButton(navController = navController)
            }
        }
    }
}

@Composable
fun NameFieldButton(
    navController: NavController
) {

    val textState = remember { mutableStateOf("") }
    val buttonEnabled by derivedStateOf {
        textState.value.isNotEmpty()
    }

    Row(Modifier.padding(16.dp)) {
        TextField(
            value = textState.value,
            onValueChange = { textState.value = it },
            modifier = Modifier.border(
                BorderStroke(width = 2.dp, color = AccentGreen),
                shape = RoundedCornerShape(50)
            ),
            colors = TextFieldDefaults.textFieldColors(
                backgroundColor = GreyBG,
                focusedIndicatorColor = GreyBG,
                unfocusedIndicatorColor = GreyBG
            ),
            label = {Text(text = "Name", color = Color.White)}
        )
    }

    Row(
        modifier = Modifier
            .padding(0.dp, 20.dp, 0.dp, 10.dp)) {
        OutlinedButton(
            enabled = buttonEnabled,
            onClick = {
                Settings.name = textState.value
                navController.navigate(Screen.SettingsScreen.route)
                },
            border = BorderStroke(2.dp, AccentGreen),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = GreyBG,
                contentColor = Color.White
            ),
            shape = RoundedCornerShape(50),
            modifier = Modifier
                .width(width = 70.dp)
                .height(height = 52.dp)
        ) {
            Text(text="Go!")
        }
    }


}





