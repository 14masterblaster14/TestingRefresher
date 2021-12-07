package com.example.roomtest.data.repositoryImpl.tvshow.datasource

import com.example.roomtest.data.model.tvshow.TvShow

interface TvShowCacheDataSource {

    suspend fun getTvShowsFromCache():List<TvShow>
    suspend fun saveTvShowsToCache(tvShows:List<TvShow>)
}