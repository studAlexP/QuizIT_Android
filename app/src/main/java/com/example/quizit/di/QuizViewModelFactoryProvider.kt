package com.example.quizit.di

import com.example.quizit.presentation.viewmodel.QuizViewModel
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ActivityComponent

@EntryPoint
@InstallIn(ActivityComponent::class)
interface QuizViewModelFactoryProvider {
    fun quizViewModelFactory(): QuizViewModel.Factory
}