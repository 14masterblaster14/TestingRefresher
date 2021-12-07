package com.example.roomtest.data.repositoryImpl.artist.datasource

import com.example.roomtest.data.model.artist.Artist

interface ArtistCacheDataSource {

    suspend fun getArtistsFromCache():List<Artist>
    suspend fun saveArtistsToCache(artists:List<Artist>)
}