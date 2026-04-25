package com.melongamesinc.workmatetestapp.domain.models

data class Character(
    val id: String,
    val name: String,
    val height: String,
    val mass: String,
    val hairColor: String,
    val eyesColor: String,
    val birthYear: String,
    val gender: String,
    val species: List<Species>,
    val films: List<Film>,
)

data class Species(
    val name: String
)

data class Film(
    val title: String,
    val filmDescription: String
)