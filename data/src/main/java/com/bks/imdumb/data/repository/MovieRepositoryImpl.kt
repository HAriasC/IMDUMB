package com.bks.imdumb.data.repository

import com.bks.imdumb.data.BuildConfig
import com.bks.imdumb.data.api.TmdbApi
import com.bks.imdumb.data.datasource.MovieDao
import com.bks.imdumb.data.model.MovieResponse
import com.bks.imdumb.domain.model.Actor
import com.bks.imdumb.domain.model.Movie
import com.bks.imdumb.domain.repository.MovieRepository
import io.reactivex.Single
import javax.inject.Inject

class MovieRepositoryImpl @Inject constructor(
    private val api: TmdbApi,
    private val dao: MovieDao
) : MovieRepository {

    private val apiKey = BuildConfig.TMDB_API_KEY

    override fun getPopularMovies(): Single<List<Movie>> {
        return fetchMovies(api.getPopularMovies(apiKey), "popular")
    }

    override fun getTopRatedMovies(): Single<List<Movie>> {
        return fetchMovies(api.getTopRatedMovies(apiKey), "top_rated")
    }

    override fun getUpcomingMovies(): Single<List<Movie>> {
        return fetchMovies(api.getUpcomingMovies(apiKey), "upcoming")
    }

    override fun getMovieDetails(movieId: Int): Single<Movie> {
        return api.getMovieDetails(movieId, apiKey).map { it.toDomain() }
    }

    /**
     * Lógica genérica para obtener películas:
     * 1. Intenta obtener datos de la API.
     * 2. Si tiene éxito, mapea a Entidad, guarda en DB local y retorna modelos de dominio.
     * 3. Si falla, carga automáticamente desde la DB local (Soporte Offline).
     */
    private fun fetchMovies(
        apiCall: Single<MovieResponse>,
        category: String
    ): Single<List<Movie>> {
        return apiCall
            .map { response ->
                val entities = response.results.map { it.toEntity(category) }
                dao.insertMovies(entities)
                entities.map { it.toDomain() }
            }
            .onErrorResumeNext {
                dao.getMoviesByCategory(category).map { entities ->
                    entities.map { it.toDomain() }
                }
            }
    }

    override fun getMovieCredits(movieId: Int): Single<List<Actor>> {
        return api.getMovieCredits(movieId, apiKey).map { response ->
            response.cast.map { it.toDomain() }
        }
    }

    override fun getMovieImages(movieId: Int): Single<List<String>> {
        return api.getMovieImages(movieId, apiKey).map { response ->
            response.backdrops.map { "${BuildConfig.IMAGE_BASE_URL_W780}${it.filePath}" }
        }
    }
}
