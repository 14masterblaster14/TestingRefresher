package com.example.roomtest.data.repositoryImpl.movie.datasource

import com.example.roomtest.data.model.movie.Movie

interface MovieCacheDataSource {

    suspend fun getMoviesFromCache():List<Movie>
    suspend fun saveMoviesToCache(movies:List<Movie>)
}