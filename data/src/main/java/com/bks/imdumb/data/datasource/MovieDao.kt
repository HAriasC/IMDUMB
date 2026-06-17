package com.bks.imdumb.data.datasource

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.bks.imdumb.data.model.MovieEntity
import io.reactivex.Single

@Dao
interface MovieDao {
    @Query("SELECT * FROM movies WHERE category = :category")
    fun getMoviesByCategory(category: String): Single<List<MovieEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertMovies(movies: List<MovieEntity>)

    @Query("DELETE FROM movies WHERE category = :category")
    fun deleteMoviesByCategory(category: String)
}
