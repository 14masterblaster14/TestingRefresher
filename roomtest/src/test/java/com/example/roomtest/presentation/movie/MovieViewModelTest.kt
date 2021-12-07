package com.example.roomtest.presentation.movie

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.roomtest.data.model.movie.Movie
import com.example.roomtest.data.repositoryImpl.movie.FakeMovieRepositoryImpl
import com.example.roomtest.domain.usecase.GetMoviesUseCase
import com.example.roomtest.domain.usecase.UpdateMoviesUseCase
import com.example.roomtest.getOrAwaitValue
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

/**
 * View Model and Live data testing with Fakes with Roboelectric framework
 */

@RunWith(AndroidJUnit4::class)
class MovieViewModelTest {

    // As we are testing live data, we need to add InstantTaskExecutorRule from JUnit Library.
    // It will run architecture related background jobs in the same thread so that the test results happens synchronously
    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    private lateinit var movieViewModel: MovieViewModel

    @Before
    fun setUp() {

        val fakeMovieRepositoryImpl = FakeMovieRepositoryImpl()
        val getMoviesUseCase = GetMoviesUseCase(fakeMovieRepositoryImpl)
        val updateMoviesUseCase = UpdateMoviesUseCase(fakeMovieRepositoryImpl)
        movieViewModel = MovieViewModel(getMoviesUseCase,updateMoviesUseCase)
    }

    @Test
    fun getMovies_returnsCurrentList(){

        val movies = mutableListOf<Movie>()
        movies.add(Movie(1, "overview1", "posterPath1", "date1", "title1"))
        movies.add(Movie(2, "overview2", "posterPath2", "date2", "title2"))

        // movieViewModel.getMovies() returns Live data, need to convert normal list for comparison
        // We will use Live data extension function i.e. Livedata Test Util (refer LiveDataTestUtil.kt)for conversion
        val currentList = movieViewModel.getMovies().getOrAwaitValue()
        assertThat(currentList).isEqualTo(movies)
    }

    @Test
    fun updateMovies_returnsUpdatedList(){

        val movies = mutableListOf<Movie>()
        movies.add(Movie(3, "overview3", "posterPath3", "date3", "title3"))
        movies.add(Movie(4, "overview4", "posterPath4", "date4", "title4"))

        // movieViewModel.getMovies() returns Live data, need to convert normal list for comparison
        // We will use Live data extension function i.e. Livedata Test Util (refer LiveDataTestUtil.kt)for conversion
        val updatedList = movieViewModel.updateMovies().getOrAwaitValue()
        assertThat(updatedList).isEqualTo(movies)
    }
}