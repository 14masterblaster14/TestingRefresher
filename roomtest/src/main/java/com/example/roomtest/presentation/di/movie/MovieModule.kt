package com.example.roomtest.presentation.di.movie

import com.example.roomtest.domain.usecase.GetMoviesUseCase
import com.example.roomtest.domain.usecase.UpdateMoviesUseCase
import com.example.roomtest.presentation.movie.MovieViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class MovieModule {

    @MovieScope
    @Provides
    fun provideMovieViewModelFactory(
        getMoviesUseCase: GetMoviesUseCase,
        updateMoviesUsecase: UpdateMoviesUseCase
    ): MovieViewModelFactory {
        return MovieViewModelFactory(
            getMoviesUseCase,
            updateMoviesUsecase
        )
    }
}