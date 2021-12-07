package com.example.roomtest.data.repositoryImpl.movie.datasourceImpl

import com.example.roomtest.data.api.TMDBService
import com.example.roomtest.data.model.movie.MovieList
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieRemoteDataSource
import retrofit2.Response

class MovieRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
) : MovieRemoteDataSource {

    override suspend fun getMovies(): Response<MovieList> = tmdbService.getPopularMovies(apiKey)
}