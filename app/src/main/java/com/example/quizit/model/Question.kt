package com.example.quizit.model

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class Question(
    @SerialName("id")
    val id: Int,
    @SerialName("question")
    val question: String,
    @SerialName("description")
    val description: String?,
    @SerialName("answers")
    val answers: Answer,
    @SerialName("multiple_correct_answers")
    val multipleCorrectAnswers: String?,
    @SerialName("correct_answers")
    val correctAnswers: CorrectAnswer,
    @SerialName("explanation")
    val explanation: String?,
    @SerialName("tip")
    val tip: String?,
    @SerialName("tags")
    val tags: List<Tag>?,
    @SerialName("category")
    val category: String?,
    @SerialName("difficulty")
    val difficulty: String?
) {
    @Serializable
    data class Answer(
        @SerialName("answer_a")
        val answerA: String?,
        @SerialName("answer_b")
        val answerB: String?,
        @SerialName("answer_c")
        val answerC: String?,
        @SerialName("answer_d")
        val answerD: String?,
        @SerialName("answer_e")
        val answerE: String?,
        @SerialName("answer_f")
        val answerF: String?
    )

    @Serializable
    data class CorrectAnswer(
        @SerialName("answer_a_correct")
        val answerACorrect: String?,
        @SerialName("answer_b_correct")
        val answerBCorrect: String?,
        @SerialName("answer_c_correct")
        val answerCCorrect: String?,
        @SerialName("answer_d_correct")
        val answerDCorrect: String?,
        @SerialName("answer_e_correct")
        val answerECorrect: String?,
        @SerialName("answer_f_correct")
        val answerFCorrect: String?,
    )

    @Serializable
    data class Tag(
        @SerialName("name")
        val name: String?
    )
}
