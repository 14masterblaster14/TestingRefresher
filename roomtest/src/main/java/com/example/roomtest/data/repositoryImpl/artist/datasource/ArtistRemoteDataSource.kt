package com.example.roomtest.data.repositoryImpl.artist.datasource

import com.example.roomtest.data.model.artist.ArtistList
import retrofit2.Response

interface ArtistRemoteDataSource {
    suspend fun getArtists(): Response<ArtistList>
}