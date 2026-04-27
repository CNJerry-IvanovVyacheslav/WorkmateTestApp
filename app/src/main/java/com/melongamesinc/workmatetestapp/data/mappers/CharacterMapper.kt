package com.melongamesinc.workmatetestapp.data.mappers

import com.melongamesinc.workmatetestapp.data.dto.CharacterDto
import com.melongamesinc.workmatetestapp.data.entities.CharacterEntity
import com.melongamesinc.workmatetestapp.domain.models.Character

private fun extractIdFromUrl(url: String): String {
    return url.trimEnd('/').split('/').lastOrNull() ?: ""
}

fun CharacterDto.toDomain(): Character {
    return Character(
        id = extractIdFromUrl(this.url),
        name = this.name,
        height = this.height,
        mass = this.mass,
        hairColor = this.hairColor,
        eyesColor = this.eyeColor,
        birthYear = this.birthYear,
        gender = this.gender,
        species = this.species,
        films = this.films
    )
}

fun CharacterDto.toEntity(): CharacterEntity {
    return CharacterEntity(
        id = extractIdFromUrl(this.url),
        name = this.name,
        height = this.height,
        mass = this.mass,
        hair = this.hairColor,
        eyes = this.eyeColor,
        birthYear = this.birthYear,
        gender = this.gender,
        films = this.films,
        species = this.species
    )
}

fun CharacterEntity.toDomain(): Character {
    return Character(
        id = this.id,
        name = this.name,
        height = this.height,
        mass = this.mass,
        hairColor = this.hair,
        eyesColor = this.eyes,
        birthYear = this.birthYear,
        gender = this.gender,
        species = this.species,
        films = this.films
    )
}