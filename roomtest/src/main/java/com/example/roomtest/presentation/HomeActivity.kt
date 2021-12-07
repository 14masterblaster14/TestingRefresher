package com.example.roomtest.presentation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import com.example.roomtest.R
import com.example.roomtest.databinding.ActivityHomeBinding
import com.example.roomtest.presentation.artist.ArtistActivity
import com.example.roomtest.presentation.movie.MovieActivity
import com.example.roomtest.presentation.tvshow.TvShowActivity

/**
 *  Room DB Testing (Instrumented Test)
 *
 *  Room library has special database builder as InMemoryDatabaseBuilder,
 *  it allows us to create temporary DB in system memory for testing
 *
 *
 *  Subject Under test :
 *                          -   MovieDao (for DB testing)           - Instrumented Tests
 *
 *                          -   MovieViewModel (for Live Data)      - Local Unit Test
 *                              Roboelectric testing framework for Fakes
 *
 */


/**
 *
 *  App Structure :-
 *
 *
 *                                     View                                     -
 *                                      |                                       |   Presentation / View, View Model,Application {
 *                                      |                                       |       di ->  Core, SubComponent
 *                                      |                                       |       Package ->
 *                                      |                                       |            Activity/Fragment,Adapter,ViewModelFactory
 *                                      |                                       |            ViewModel (UseCases)
 *                                      |                                       |
 *                                      |                                       |
 *                                      |                                       |
 *                                  View Model                                  -
 *                                      |
 *                                  Use Case                                    -
 *                                      |                                       |   Domain { Use Case   -> Use Case class (Repo),
 *                                      |                                       |            Repository -> Repository interface}
 *                                      |                                       |
 *                                  Repository                                  -
 *                                      |                                       |
 *                                      |                                       |   Data {
 *                   ________________________________________                   |           API   ->          {Service Interface}
 *                  |                                       |                   |           Model ->           Package ->    {Models/Entities}
 *          Local Data Source                       Remote Data Source          |           DB    ->          {Dao interface,DB abstract class}
 *                                                                              |           RepositoryImpl  ->
 *                                                                              |                       Package ->
 *                                                                              |                           datasource -> {CacheDS, LocalDS, RemoteDS}
 *                                                                              |                           datasourceImpl -> {CacheDSImpl, LocalDSImpl(Dao), RemoteDSImpl(ServiceInterface,APIKey)}
 *                                                                              |                       RepositoryImpl class (CacheDS, LocalDS, RemoteDS)
 *                                                                              |
 *                                                                              -
 *
 *  Note : Always starts with Domain Layer, Data Layer and then Presentation Layer
 *
 *  Use Cases ->    Movie   -> View Movies
 *                          -> update Movies
 *
 *                  TvShow  -> View Tv Shows
 *                          -> Update Tv Shows
 *
 *                  Artists -> View Artists
 *                          -> Update Artists
 *
 *  Note: Use Dependency Graph in drawable folder.
 *
 **/

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
       // setContentView(R.layout.activity_home)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_home)
        binding.movieButton.setOnClickListener {
            val intent = Intent(this, MovieActivity::class.java)
            startActivity(intent)
        }

        binding.tvButton.setOnClickListener {
            val intent = Intent(this, TvShowActivity::class.java)
            startActivity(intent)
        }

        binding.artistsButton.setOnClickListener {
            val intent = Intent(this, ArtistActivity::class.java)
            startActivity(intent)
        }
    }
}