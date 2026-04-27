package com.melongamesinc.workmatetestapp.domain.repository

import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.models.Film
import com.melongamesinc.workmatetestapp.domain.models.Species

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharactersById(id: String): Character

    suspend fun searchCharacter(query: String): List<Character>

    suspend fun getFilmById(id: String): Film

    suspend fun getSpeciesById(id: String): Species
}