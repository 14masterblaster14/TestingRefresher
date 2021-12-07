package com.example.roomtest.presentation.di.artist

import com.example.roomtest.domain.usecase.GetArtistsUseCase
import com.example.roomtest.domain.usecase.UpdateArtistsUseCase
import com.example.roomtest.presentation.artist.ArtistViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class ArtistModule {
    @ArtistScope
    @Provides
    fun provideArtistViewModelFactory(
        getArtistsUseCase: GetArtistsUseCase,
        updateArtistsUseCase: UpdateArtistsUseCase
    ): ArtistViewModelFactory {
        return ArtistViewModelFactory(
            getArtistsUseCase,
            updateArtistsUseCase
        )
    }
}