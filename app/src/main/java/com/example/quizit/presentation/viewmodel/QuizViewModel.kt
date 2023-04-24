package com.example.quizit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.quizit.services.KtorClient
import com.example.quizit.model.Question
import com.example.quizit.services.QuizApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class QuizViewModel : ViewModel() {

    var quizApi = QuizApi(KtorClient.client)

    private val _questions = MutableStateFlow<List<Question>?>(null)
    val questions: StateFlow<List<Question>?> = _questions



    fun getQuestions(
        category: String,
        difficulty: String,
        limit: String
    ) {
        viewModelScope.launch {
            _questions.value = quizApi.getQuestion(
                category = category,
                difficulty = difficulty,
                limit = limit
            )
        }
    }
}