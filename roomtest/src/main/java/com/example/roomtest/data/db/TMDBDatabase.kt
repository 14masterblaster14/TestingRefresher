package com.example.roomtest.data.db

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.roomtest.data.db.ArtistDao
import com.example.roomtest.data.db.MovieDao
import com.example.roomtest.data.model.artist.Artist
import com.example.roomtest.data.model.movie.Movie
import com.example.roomtest.data.model.tvshow.TvShow


@Database(entities = [Movie::class, TvShow::class, Artist::class],
//@Database(entities = [Movie::class],
    version = 1,
    exportSchema = false
)
abstract class TMDBDatabase : RoomDatabase() {

    abstract fun movieDao(): MovieDao
    abstract fun tvDao(): TvShowDao
    abstract fun artistDao(): ArtistDao
}