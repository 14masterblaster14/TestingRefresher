package com.example.roomtest.presentation.di.tvshow

import com.example.roomtest.domain.usecase.GetTvShowsUseCase
import com.example.roomtest.domain.usecase.UpdateTvShowsUseCase
import com.example.roomtest.presentation.tvshow.TvShowViewModelFactory
import dagger.Module
import dagger.Provides

@Module
class TvShowModule {

    @TvShowScope
    @Provides
    fun provideTvShowViewModelFactory(
        getTvShowsUseCase: GetTvShowsUseCase,
        updateTvShowsUseCase: UpdateTvShowsUseCase
    ): TvShowViewModelFactory {
        return TvShowViewModelFactory(
            getTvShowsUseCase,
            updateTvShowsUseCase
        )
    }

}