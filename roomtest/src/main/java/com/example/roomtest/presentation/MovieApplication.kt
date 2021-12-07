package com.example.roomtest.presentation

import android.app.Application
import com.example.roomtest.BuildConfig
import com.example.roomtest.presentation.di.artist.ArtistSubComponent
import com.example.roomtest.presentation.di.Injector
import com.example.roomtest.presentation.di.core.*
import com.example.roomtest.presentation.di.movie.MovieSubComponent
import com.example.roomtest.presentation.di.tvshow.TvShowSubComponent

class MovieApplication : Application(), Injector {

    private lateinit var appComponent: AppComponent

    override fun onCreate() {
        super.onCreate()
        appComponent = DaggerAppComponent.builder()         // Need to add only modules with constructor parameter
            .appModule(AppModule(applicationContext))
            .netModule(NetModule(BuildConfig.BASE_URL))
            .remoteDataModule(RemoteDataModule(BuildConfig.API_KEY))
            .build()

    }

    override fun createMovieSubComponent(): MovieSubComponent {
        return appComponent.movieSubComponent().create()
    }

    override fun createTvShowSubComponent(): TvShowSubComponent {
        return appComponent.tvShowSubComponent().create()
    }

    override fun createArtistSubComponent(): ArtistSubComponent {
        return appComponent.artistSubComponent().create()
    }
}