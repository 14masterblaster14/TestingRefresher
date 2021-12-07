package com.example.roomtest.data.repositoryImpl.artist.datasource

import com.example.roomtest.data.model.artist.Artist

interface ArtistLocalDataSource {

    suspend fun getArtistsFromDB():List<Artist>
    suspend fun saveArtistsToDB(artists:List<Artist>)
    suspend fun clearAll()
}