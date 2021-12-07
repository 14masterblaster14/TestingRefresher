package com.example.roomtest.data.repositoryImpl.movie.datasourceImpl

import com.example.roomtest.data.model.movie.Movie
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieCacheDataSource

class MovieCacheDataSourceImpl : MovieCacheDataSource {

    private var movieList = ArrayList<Movie>()

    override suspend fun getMoviesFromCache(): List<Movie> {
        return movieList
    }

    override suspend fun saveMoviesToCache(movies: List<Movie>) {
        movieList.clear()
        movieList = ArrayList(movies)
    }
}