package com.example.roomtest.presentation.di.core

import com.example.roomtest.presentation.di.artist.ArtistSubComponent
import com.example.roomtest.presentation.di.movie.MovieSubComponent
import com.example.roomtest.presentation.di.tvshow.TvShowSubComponent
import dagger.Component
import javax.inject.Singleton

@Singleton
@Component(modules = [
    NetModule::class,
    DataBaseModule::class,
    CacheDataModule::class,
    LocalDataModule::class,
    RemoteDataModule::class,
    RepositoryModule::class,
    UseCaseModule::class,
    AppModule::class])

interface AppComponent {

    fun movieSubComponent(): MovieSubComponent.Factory
    fun tvShowSubComponent(): TvShowSubComponent.Factory
    fun artistSubComponent(): ArtistSubComponent.Factory
}