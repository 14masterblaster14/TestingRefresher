package com.example.roomtest.domain.usecase

import com.example.roomtest.data.model.tvshow.TvShow
import com.example.roomtest.domain.repository.TvShowRepository

class UpdateTvShowsUseCase (private val tvShowRepository: TvShowRepository) {
    suspend fun execute():List<TvShow>?=tvShowRepository.updateTvShows()
}