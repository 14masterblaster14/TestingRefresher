package com.example.roomtest.domain.usecase

import com.example.roomtest.data.model.artist.Artist
import com.example.roomtest.domain.repository.ArtistRepository

class GetArtistsUseCase (private val artistRepository: ArtistRepository) {
    suspend fun execute():List<Artist>? = artistRepository.getArtists()

}