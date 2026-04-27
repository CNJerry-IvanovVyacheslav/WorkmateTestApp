package com.melongamesinc.workmatetestapp.data.dto

import kotlinx.serialization.Serializable
import com.melongamesinc.workmatetestapp.domain.models.Species

@Serializable
data class SpeciesDto(
    val name: String,
    val url: String
)

fun SpeciesDto.toDomain(): Species {
    return Species(
        id = this.url.trimEnd('/').substringAfterLast('/'),
        name = this.name
    )
}