package com.melongamesinc.workmatetestapp.domain.repository

import com.melongamesinc.workmatetestapp.domain.models.Character

interface CharacterRepository {
    suspend fun getCharacters(): List<Character>

    suspend fun getCharactersById(id: String) : Character

    suspend fun searchCharacter(query: String): List<Character>
}