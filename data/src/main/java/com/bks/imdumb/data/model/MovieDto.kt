package com.bks.imdumb.data.model

import com.google.gson.annotations.SerializedName

data class MovieResponse(
    @SerializedName("results") val results: List<MovieDto>
)

data class MovieDto(
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("overview") val overview: String,
    @SerializedName("poster_path") val posterPath: String?,
    @SerializedName("backdrop_path") val backdropPath: String?,
    @SerializedName("vote_average") val voteAverage: Double,
    @SerializedName("release_date") val releaseDate: String?,
    @SerializedName("adult") val adult: Boolean?,
    @SerializedName("runtime") val runtime: Int?,
    @SerializedName("genres") val genres: List<GenreDto>?
)

data class GenreDto(
    @SerializedName("name") val name: String
)

data class CreditsResponse(
    @SerializedName("cast") val cast: List<CastDto>
)

data class CastDto(
    @SerializedName("name") val name: String,
    @SerializedName("character") val character: String,
    @SerializedName("profile_path") val profilePath: String?
)

data class ImagesResponse(
    @SerializedName("backdrops") val backdrops: List<ImageDto>
)

data class ImageDto(
    @SerializedName("file_path") val filePath: String
)
