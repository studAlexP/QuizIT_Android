package com.example.quizit.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.example.quizit.data.repository.QuizRepositoryImpl
import com.example.quizit.domain.model.Question
import com.example.quizit.domain.repository.QuizRepository
import dagger.assisted.Assisted
import dagger.assisted.AssistedFactory
import dagger.assisted.AssistedInject
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class QuizViewModel @AssistedInject constructor(
    private val quizRepository: QuizRepository,
    @Assisted("category")
    private val category: String,
    @Assisted("difficulty")
    private val difficulty: String,
    @Assisted("limit")
    private val limit: String
): ViewModel() {

    private val _questions = MutableStateFlow<List<Question>?>(null)
    val questions: StateFlow<List<Question>?> = _questions

    init {
        getQuestions()
    }

    private fun getQuestions() {
        viewModelScope.launch {
            _questions.value = quizRepository.getQuestions(
                category = category,
                difficulty = difficulty,
                limit = limit
            )
        }
    }

    @AssistedFactory
    interface Factory {
        fun create(
            @Assisted("category") category: String,
            @Assisted("difficulty") difficulty: String,
            @Assisted("limit") limit: String
        ) : QuizViewModel
    }

    companion object {
        fun provideQuizViewModelFactory(
            factory: Factory,
            category: String,
            difficulty: String,
            limit: String
        ) : ViewModelProvider.Factory {
            return object: ViewModelProvider.Factory {
                override fun <T : ViewModel> create(modelClass: Class<T>): T {
                    return factory.create(category, difficulty, limit) as T
                }
            }
        }
    }
}