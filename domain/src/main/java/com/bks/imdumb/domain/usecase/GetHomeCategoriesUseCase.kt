package com.bks.imdumb.domain.usecase

import com.bks.imdumb.domain.model.MovieCategory
import com.bks.imdumb.domain.repository.MovieRepository
import io.reactivex.Single
import io.reactivex.rxkotlin.Singles
import javax.inject.Inject

/**
 * SOLID: Open/Closed Principle (OCP)
 * Esta lógica de combinación es extensible; si se agregan más categorías,
 * no es necesario modificar la estructura base del Repositorio.
 */
class GetHomeCategoriesUseCase @Inject constructor(
    private val repository: MovieRepository
) {
    fun execute(): Single<List<MovieCategory>> {
        return Singles.zip(
            repository.getPopularMovies(),
            repository.getTopRatedMovies(),
            repository.getUpcomingMovies()
        ) { popular, topRated, upcoming ->
            listOf(
                MovieCategory("Populares", popular),
                MovieCategory("Mejor Valoradas", topRated),
                MovieCategory("Próximamente", upcoming)
            )
        }
    }
}
