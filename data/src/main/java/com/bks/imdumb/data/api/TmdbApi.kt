package com.bks.imdumb.data.api

import com.bks.imdumb.data.model.CreditsResponse
import com.bks.imdumb.data.model.ImagesResponse
import com.bks.imdumb.data.model.MovieDto
import com.bks.imdumb.data.model.MovieResponse
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface TmdbApi {
    @GET("movie/popular")
    fun getPopularMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "es-ES"
    ): Single<MovieResponse>

    @GET("movie/top_rated")
    fun getTopRatedMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "es-ES"
    ): Single<MovieResponse>

    @GET("movie/upcoming")
    fun getUpcomingMovies(
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "es-ES"
    ): Single<MovieResponse>

    @GET("movie/{movie_id}")
    fun getMovieDetails(
        @retrofit2.http.Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String,
        @Query("language") language: String = "es-ES"
    ): Single<MovieDto>

    @GET("movie/{movie_id}/credits")
    fun getMovieCredits(
        @retrofit2.http.Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Single<CreditsResponse>

    @GET("movie/{movie_id}/images")
    fun getMovieImages(
        @retrofit2.http.Path("movie_id") movieId: Int,
        @Query("api_key") apiKey: String
    ): Single<ImagesResponse>
}
