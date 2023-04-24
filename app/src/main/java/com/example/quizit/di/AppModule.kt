package com.example.quizit.di

import com.example.quizit.BuildConfig
import com.example.quizit.data.network.QuizApi
import com.example.quizit.data.network.QuizApiImpl
import com.example.quizit.data.repository.QuizRepositoryImpl
import com.example.quizit.domain.repository.QuizRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.ktor.client.*
import io.ktor.client.engine.android.*
import io.ktor.client.plugins.*
import io.ktor.client.plugins.contentnegotiation.*
import io.ktor.client.plugins.logging.*
import io.ktor.http.*
import io.ktor.serialization.kotlinx.json.*
import kotlinx.serialization.json.Json
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideQuizApi(): QuizApi {
        return QuizApiImpl(
            client = HttpClient(Android) {
                install(Logging) {
                    level = LogLevel.ALL
                }

                install(ContentNegotiation) {
                    json(Json {
                        prettyPrint = true
                        isLenient = true
                        ignoreUnknownKeys = true
                    })
                }
                install(HttpTimeout) {
                    requestTimeoutMillis = 15000L
                    connectTimeoutMillis = 15000L
                    socketTimeoutMillis = 15000L
                }

                defaultRequest {
                    url {
                        protocol = URLProtocol.HTTPS
                        host = "quizapi.io"
                        path("api/v1/questions")
                        parameters.append("apiKey", BuildConfig.API_KEY)
                    }
                }
            }
        )
    }

    @Provides
    @Singleton
    fun provideQuizRepository(api: QuizApi): QuizRepository {
        return QuizRepositoryImpl(api = api)
    }
}