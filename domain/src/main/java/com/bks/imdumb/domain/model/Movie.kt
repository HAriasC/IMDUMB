package com.bks.imdumb.domain.model

data class Movie(
    val id: Int,
    val title: String,
    val overview: String,
    val posterUrl: String,
    val backdropUrl: String,
    val rating: Double,
    val isAdult: Boolean = false,
    val genres: List<String> = emptyList()
)
