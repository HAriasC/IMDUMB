package com.bks.imdumb.data.repository

import com.bks.imdumb.data.BuildConfig
import com.bks.imdumb.data.model.CastDto
import com.bks.imdumb.data.model.MovieDto
import com.bks.imdumb.data.model.MovieEntity
import com.bks.imdumb.domain.model.Actor
import com.bks.imdumb.domain.model.Movie

fun MovieDto.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = "${BuildConfig.IMAGE_BASE_URL_W500}$posterPath",
        backdropUrl = "${BuildConfig.IMAGE_BASE_URL_W780}$backdropPath",
        rating = voteAverage,
        isAdult = adult ?: false,
        genres = genres?.map { it.name } ?: emptyList()
    )
}

fun MovieDto.toEntity(category: String): MovieEntity {
    return MovieEntity(
        id = id,
        title = title,
        overview = overview,
        posterUrl = "${BuildConfig.IMAGE_BASE_URL_W500}$posterPath",
        backdropUrl = "${BuildConfig.IMAGE_BASE_URL_W780}$backdropPath",
        rating = voteAverage,
        isAdult = adult ?: false,
        genres = genres?.joinToString(",") { it.name } ?: "",
        category = category
    )
}

fun MovieEntity.toDomain(): Movie {
    return Movie(
        id = id,
        title = title,
        overview = overview,
        posterUrl = posterUrl,
        backdropUrl = backdropUrl,
        rating = rating,
        isAdult = isAdult,
        genres = if (genres.isEmpty()) emptyList() else genres.split(",")
    )
}

fun CastDto.toDomain(): Actor {
    return Actor(
        name = name,
        character = character,
        photoUrl = profilePath?.let { "${BuildConfig.IMAGE_BASE_URL_W500}$it" }
    )
}
