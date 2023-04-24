package com.example.quizit.data.network

import com.example.quizit.domain.model.Question
import io.ktor.client.*
import io.ktor.client.call.*
import io.ktor.client.plugins.*
import io.ktor.client.request.*

class QuizApiImpl(
    private val client: HttpClient
): QuizApi {

    override suspend fun getQuestion(
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