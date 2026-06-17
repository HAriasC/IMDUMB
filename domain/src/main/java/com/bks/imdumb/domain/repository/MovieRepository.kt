package com.bks.imdumb.domain.repository

import com.bks.imdumb.domain.model.Actor
import com.bks.imdumb.domain.model.Movie
import io.reactivex.Single

/**
 * SOLID: Dependency Inversion Principle (DIP)
 * Las capas superiores (Domain/UseCases) dependen de esta abstracción y no de la 
 * implementación concreta en la capa de Data.
 */
interface MovieRepository {
    fun getPopularMovies(): Single<List<Movie>>
    fun getTopRatedMovies(): Single<List<Movie>>
    fun getUpcomingMovies(): Single<List<Movie>>
    fun getMovieDetails(movieId: Int): Single<Movie>
    fun getMovieCredits(movieId: Int): Single<List<Actor>>
    fun getMovieImages(movieId: Int): Single<List<String>>
}
