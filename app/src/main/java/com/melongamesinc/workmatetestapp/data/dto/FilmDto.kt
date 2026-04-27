package com.melongamesinc.workmatetestapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import com.melongamesinc.workmatetestapp.domain.models.Film

@Serializable
data class FilmDto(
    val title: String,
    @SerialName("opening_crawl")
    val openingCrawl: String,
    val url: String
)

fun FilmDto.toDomain(): Film {
    return Film(
        id = this.url.trimEnd('/').substringAfterLast('/'),
        title = this.title,
        openingCrawl = this.openingCrawl
    )
}