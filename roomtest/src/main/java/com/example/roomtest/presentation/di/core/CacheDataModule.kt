package com.example.roomtest.presentation.di.core

import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistCacheDataSource
import com.example.roomtest.data.repositoryImpl.artist.datasourceImpl.ArtistCacheDataSourceImpl
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieCacheDataSource
import com.example.roomtest.data.repositoryImpl.movie.datasourceImpl.MovieCacheDataSourceImpl
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowCacheDataSource
import com.example.roomtest.data.repositoryImpl.tvshow.datasourceImpl.TvShowCacheDataSourceImpl
import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class CacheDataModule {

    @Singleton
    @Provides
    fun provideMovieCacheDataSource(): MovieCacheDataSource {
        return MovieCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideTvShowCacheDataSource(): TvShowCacheDataSource {
        return TvShowCacheDataSourceImpl()
    }

    @Singleton
    @Provides
    fun provideArtistCacheDataSource(): ArtistCacheDataSource {
        return ArtistCacheDataSourceImpl()
    }


}