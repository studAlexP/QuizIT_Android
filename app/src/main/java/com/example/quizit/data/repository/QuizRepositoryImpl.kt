package com.example.quizit.data.repository

import com.example.quizit.data.network.QuizApi
import com.example.quizit.domain.model.Question
import com.example.quizit.domain.repository.QuizRepository

class QuizRepositoryImpl(
    private val api: QuizApi
): QuizRepository {

    override suspend fun getQuestions(
        category: String,
        difficulty: String,
        limit: String
    ): List<Question> {
        return api.getQuestion(
            category = category,
            difficulty = difficulty,
            limit = limit
        )
    }
}