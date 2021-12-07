package com.example.roomtest.data.repositoryImpl.tvshow.datasourceImpl

import com.example.roomtest.data.model.tvshow.TvShow
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowCacheDataSource

class TvShowCacheDataSourceImpl  :
    TvShowCacheDataSource {
    private var tvShowList = ArrayList<TvShow>()

    override suspend fun getTvShowsFromCache(): List<TvShow> {
        return tvShowList
    }

    override suspend fun saveTvShowsToCache(tvShows: List<TvShow>) {
        tvShowList.clear()
        tvShowList = ArrayList(tvShows)
    }
}