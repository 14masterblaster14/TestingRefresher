package com.example.roomtest.presentation.di.core

import com.example.roomtest.data.db.ArtistDao
import com.example.roomtest.data.db.MovieDao
import com.example.roomtest.data.db.TvShowDao
import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistLocalDataSource
import com.example.roomtest.data.repositoryImpl.artist.datasourceImpl.ArtistLocalDataSourceImpl
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieLocalDataSource
import com.example.roomtest.data.repositoryImpl.movie.datasourceImpl.MovieLocalDataSourceImpl
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowLocalDataSource
import com.example.roomtest.data.repositoryImpl.tvshow.datasourceImpl.TvShowLocalDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class LocalDataModule {


    @Singleton
    @Provides
    fun provideMovieLocalDataSource(movieDao: MovieDao): MovieLocalDataSource {
        return MovieLocalDataSourceImpl(movieDao)
    }

    @Singleton
    @Provides
    fun provideTvShowLocalDataSource(tvShowDao: TvShowDao): TvShowLocalDataSource {
        return TvShowLocalDataSourceImpl(tvShowDao)
    }

    @Singleton
    @Provides
    fun provideArtistLocalDataSource(artistDao : ArtistDao): ArtistLocalDataSource {
        return ArtistLocalDataSourceImpl(artistDao)
    }

}