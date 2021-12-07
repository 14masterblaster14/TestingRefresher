package com.example.roomtest.domain.usecase

import com.example.roomtest.data.model.movie.Movie
import com.example.roomtest.domain.repository.MovieRepository

class UpdateMoviesUseCase (private val movieRepository: MovieRepository) {

    suspend fun execute():List<Movie>? = movieRepository.updateMovies()
}