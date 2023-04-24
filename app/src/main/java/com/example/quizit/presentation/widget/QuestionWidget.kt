package com.example.quizit.presentation.widget

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.DarkGray
import androidx.compose.ui.graphics.Color.Companion.Transparent
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.example.quizit.model.Question
import com.example.quizit.ui.theme.AccentGreen
import com.example.quizit.ui.theme.GreyBG
import com.example.quizit.ui.theme.LightGrey


@Composable
fun DisplayQuestion(

    quiz: List<Question>,
    endButtonPressed: () -> Unit
) {
    val questionIndex = remember {
        mutableStateOf(0)
    }
    val buttonEnabled by derivedStateOf {
        questionIndex.value >= 1
    }

    Scaffold(
        backgroundColor = GreyBG,
        topBar = {
            TopAppBar(
                backgroundColor = GreyBG,
                elevation = 3.dp
            ) {
                Row {
                    IconButton(
                        enabled = buttonEnabled,
                        onClick = { questionIndex.value = questionIndex.value - 1 }
                    ) {
                        Icon(
                            imageVector = Icons.Filled.ArrowBack,
                            "backIcon"
                        )
                    }
                    Text(
                        color = Color.White,
                        text = quiz[questionIndex.value].category.toString(),
                        modifier = Modifier.padding(top = 13.dp)
                    )
                }
            }
        }
    ) {
        Row(
            horizontalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(10.dp, 50.dp, 10.dp, 10.dp)
        ) {
            Text(text = quiz[questionIndex.value].question)
        }

        val answerStates = remember {
            List(6) { mutableStateOf(false) }
        }

        Column(

            modifier = Modifier
                .verticalScroll(rememberScrollState())
                .fillMaxSize()
                .padding(50.dp, 150.dp, 50.dp)
        ) {
            if (quiz[questionIndex.value].answers.answerA != null) {
                AnswerChip(
                    isSelected = answerStates[0].value,
                    text = quiz[questionIndex.value].answers.answerA.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[0].value = it
                    }
                )
            }
            if (quiz[questionIndex.value].answers.answerB != null) {
                AnswerChip(
                    isSelected = answerStates[1].value,
                    text = quiz[questionIndex.value].answers.answerB.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[1].value = it
                    }
                )
            }
            if (quiz[questionIndex.value].answers.answerC != null) {
                AnswerChip(
                    isSelected = answerStates[2].value,
                    text = quiz[questionIndex.value].answers.answerC.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[2].value = it
                    }
                )
            }
            if (quiz[questionIndex.value].answers.answerD != null) {
                AnswerChip(
                    isSelected = answerStates[3].value,
                    text = quiz[questionIndex.value].answers.answerD.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[3].value = it
                    }
                )
            }
            if (quiz[questionIndex.value].answers.answerE != null) {
                AnswerChip(
                    isSelected = answerStates[4].value,
                    text = quiz[questionIndex.value].answers.answerE.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[4].value = it
                    }
                )
            }
            if (quiz[questionIndex.value].answers.answerF != null) {
                AnswerChip(
                    isSelected = answerStates[5].value,
                    text = quiz[questionIndex.value].answers.answerF.toString(),
                    selectedColor = DarkGray,
                    onChecked = {
                        answerStates[5].value = it
                    }
                )
            }
        }

        Row(
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(10.dp, 620.dp, 10.dp, 10.dp)
        ) {
            val context = LocalContext.current
            OutlinedButton(
                shape = RoundedCornerShape(40),
                colors = ButtonDefaults.buttonColors(
                    backgroundColor = GreyBG,
                    contentColor = Color.White
                ),
                border = BorderStroke(2.dp, AccentGreen),
                onClick = {
                    answerStates[0].value = false
                    answerStates[1].value = false
                    answerStates[2].value = false
                    answerStates[3].value = false
                    answerStates[4].value = false
                    answerStates[5].value = false

                    Toast.makeText(
                        context,
                        "The correct answers are now highlighted",
                        Toast.LENGTH_SHORT
                    ).show()

                    if (quiz[questionIndex.value].correctAnswers.answerACorrect.toString() == "true") {
                        answerStates[0].value = true
                    }
                    if (quiz[questionIndex.value].correctAnswers.answerBCorrect.toString() == "true") {
                        answerStates[1].value = true
                    }
                    if (quiz[questionIndex.value].correctAnswers.answerCCorrect.toString() == "true") {
                        answerStates[2].value = true
                    }
                    if (quiz[questionIndex.value].correctAnswers.answerDCorrect.toString() == "true") {
                        answerStates[3].value = true
                    }
                    if (quiz[questionIndex.value].correctAnswers.answerECorrect.toString() == "true") {
                        answerStates[4].value = true
                    }
                    if (quiz[questionIndex.value].correctAnswers.answerFCorrect.toString() == "true") {
                        answerStates[5].value = true
                    }
                }
            ) {
                Text(text = "Check Answers")
            }

            if (questionIndex.value + 1 < quiz.size) {
                OutlinedButton(
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GreyBG,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.dp, AccentGreen),
                    onClick = {
                        questionIndex.value = questionIndex.value + 1
                        answerStates[0].value = false
                        answerStates[1].value = false
                        answerStates[2].value = false
                        answerStates[3].value = false
                        answerStates[4].value = false
                        answerStates[5].value = false
                    }
                ) {
                    Text(text = "Next")
                }
            } else {
                OutlinedButton(
                    onClick = { endButtonPressed() },
                    shape = RoundedCornerShape(40),
                    colors = ButtonDefaults.buttonColors(
                        backgroundColor = GreyBG,
                        contentColor = Color.White
                    ),
                    border = BorderStroke(2.dp, AccentGreen)
                ) {
                    Text(text = "End")
                }
            }
        }
    }
}

@Composable
fun AnswerChip(
    isSelected: Boolean,
    text: String,
    onChecked: (Boolean) -> Unit,
    selectedColor: Color = AccentGreen
) {
    Column(
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .padding(
                5.dp, 0.dp, 0.dp, 10.dp
            )
            .fillMaxWidth()
            .border(
                width = 1.dp,
                color = if (isSelected) AccentGreen else LightGrey,
                shape = RoundedCornerShape(40)
            )
            .background(
                color = if (isSelected) selectedColor else Transparent,
                shape = RoundedCornerShape(40)
            )
            .clickable {
                onChecked(!isSelected)
            }
    ) {
        Text(
            text = text,
            modifier = Modifier
                .padding(15.dp),
            textAlign = TextAlign.Center
        )
    }
}

