package com.example.roomtest.data.repositoryImpl.tvshow.datasource

import com.example.roomtest.data.model.tvshow.TvShowList
import retrofit2.Response

interface TvShowRemoteDataSource {

    suspend fun getTvShows(): Response<TvShowList>
}