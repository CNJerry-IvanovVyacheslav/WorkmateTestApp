package com.melongamesinc.workmatetestapp.data.impl

import com.melongamesinc.workmatetestapp.data.api.StarWarsApi
import com.melongamesinc.workmatetestapp.data.mappers.toDomain
import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(private val api: StarWarsApi) : CharacterRepository {
    override suspend fun getCharacters(): List<Character> {
        return api.getCharacters().results.map { it.toDomain() }
    }

    override suspend fun getCharactersById(id: String): Character {
        return api.getCharacterById(id).toDomain()
    }

    override suspend fun searchCharacter(query: String): List<Character> {
        return api.searchCharacter(query).results.map { it.toDomain() }
    }
}