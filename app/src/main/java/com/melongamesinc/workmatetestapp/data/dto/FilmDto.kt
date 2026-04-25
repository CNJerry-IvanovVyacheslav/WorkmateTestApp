package com.melongamesinc.workmatetestapp.data.dto

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@Serializable
data class FilmDto(
    val title: String,
    @SerialName("opening_crawl")
    val openingCrawl: String
)
