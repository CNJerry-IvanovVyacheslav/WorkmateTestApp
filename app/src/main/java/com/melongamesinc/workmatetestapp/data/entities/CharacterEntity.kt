package com.melongamesinc.workmatetestapp.data.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "characters")
data class CharacterEntity(
    @PrimaryKey val id: String,
    val name: String,
    val height: String,
    val mass: String,
    val hair: String,
    val eyes: String,
    val birthYear: String,
    val gender: String,
    val films: List<String>,
    val species: List<String>
)