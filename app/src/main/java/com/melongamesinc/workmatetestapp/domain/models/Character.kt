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
    val films: List<String>,
    val species: List<String>
)