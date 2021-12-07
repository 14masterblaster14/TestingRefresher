package com.example.roomtest.data.repositoryImpl.artist.datasourceImpl

import com.example.roomtest.data.api.TMDBService
import com.example.roomtest.data.model.artist.ArtistList
import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistRemoteDataSource
import retrofit2.Response

class ArtistRemoteDataSourceImpl (
    private val tmdbService: TMDBService,
    private val apiKey:String
): ArtistRemoteDataSource {
    override suspend fun getArtists()
            : Response<ArtistList> = tmdbService.getPopularArtists(apiKey)

}