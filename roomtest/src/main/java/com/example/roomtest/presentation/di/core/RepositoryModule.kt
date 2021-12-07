package com.example.roomtest.presentation.di.core

import com.example.roomtest.data.repositoryImpl.artist.ArtistRepositoryImpl
import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistCacheDataSource
import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistLocalDataSource
import com.example.roomtest.data.repositoryImpl.artist.datasource.ArtistRemoteDataSource
import com.example.roomtest.data.repositoryImpl.movie.MovieRepositoryImpl
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieCacheDataSource
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieLocalDataSource
import com.example.roomtest.data.repositoryImpl.movie.datasource.MovieRemoteDataSource
import com.example.roomtest.data.repositoryImpl.tvshow.TvShowRepositoryImpl
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowCacheDataSource
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowLocalDataSource
import com.example.roomtest.data.repositoryImpl.tvshow.datasource.TvShowRemoteDataSource
import com.example.roomtest.domain.repository.ArtistRepository
import com.example.roomtest.domain.repository.MovieRepository
import com.example.roomtest.domain.repository.TvShowRepository
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class RepositoryModule {

    @Provides
    @Singleton
    fun provideMovieRepository(
        movieRemoteDatasource: MovieRemoteDataSource,
        movieLocalDataSource: MovieLocalDataSource,
        movieCacheDataSource: MovieCacheDataSource
    ): MovieRepository {

        return MovieRepositoryImpl(
            movieRemoteDatasource,
            movieLocalDataSource,
            movieCacheDataSource
        )
    }


    @Provides
    @Singleton
    fun provideTvShowRepository(
        tvShowRemoteDatasource: TvShowRemoteDataSource,
        tvShowLocalDataSource: TvShowLocalDataSource,
        tvShowCacheDataSource: TvShowCacheDataSource
    ): TvShowRepository {

        return TvShowRepositoryImpl(
            tvShowRemoteDatasource,
            tvShowLocalDataSource,
            tvShowCacheDataSource
        )
    }


    @Provides
    @Singleton
    fun provideArtistRepository(
        artistRemoteDatasource: ArtistRemoteDataSource,
        artistLocalDataSource: ArtistLocalDataSource,
        artistCacheDataSource: ArtistCacheDataSource
    ): ArtistRepository {

        return ArtistRepositoryImpl(
            artistRemoteDatasource,
            artistLocalDataSource,
            artistCacheDataSource
        )
    }


}