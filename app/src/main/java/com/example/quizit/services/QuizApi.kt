package com.example.quizit.services

import com.example.quizit.model.Question
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class QuizApi(
    private val client: HttpClient
) {

    suspend fun getQuestion(
        category: String,
        difficulty: String,
        limit: String
    ): List<Question> {
        return try{
            client.get{
                url {
                    parameters.append("category", category)
                    parameters.append("difficulty", difficulty)
                    parameters.append("limit", limit)
                }
            }.body()
        } catch (e: RedirectResponseException) {
            // 3xx - response
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ClientRequestException) {
            // 4xx - response
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: ServerResponseException) {
            // 5xx - response
            println("Error: ${e.response.status.description}")
            emptyList()
        } catch (e: Exception) {
            println("Error: ${e.message}")
            emptyList()
        }
    }
}