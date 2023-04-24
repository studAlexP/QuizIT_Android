package com.example.quizit.data.network

import com.example.quizit.BuildConfig
import com.example.quizit.domain.model.Question
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json

interface QuizApi {

    suspend fun getQuestion(
        category: String,
        difficulty: String,
        limit: String
    ): List<Question>
}