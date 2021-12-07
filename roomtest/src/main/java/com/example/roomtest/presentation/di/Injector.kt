package com.example.roomtest.presentation.di

import com.example.roomtest.presentation.di.artist.ArtistSubComponent
import com.example.roomtest.presentation.di.movie.MovieSubComponent
import com.example.roomtest.presentation.di.tvshow.TvShowSubComponent

interface Injector {

    fun createMovieSubComponent(): MovieSubComponent
    fun createTvShowSubComponent(): TvShowSubComponent
    fun createArtistSubComponent(): ArtistSubComponent
}