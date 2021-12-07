package com.example.roomtest.data.repositoryImpl.movie.datasource

import com.example.roomtest.data.model.movie.MovieList
import retrofit2.Response

interface MovieRemoteDataSource {

    suspend fun getMovies(): Response<MovieList>
}