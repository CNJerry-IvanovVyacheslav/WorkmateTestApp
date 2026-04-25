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
    val films: List<Films>,
)

data class Species(
    val name: String
)

data class Films(
    val title: String,
    val filmDescription: String
)