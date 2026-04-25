package com.melongamesinc.workmatetestapp.data.impl

import android.util.Log
import com.melongamesinc.workmatetestapp.data.api.StarWarsApi
import com.melongamesinc.workmatetestapp.data.db.CharacterDao
import com.melongamesinc.workmatetestapp.data.mappers.toDomain
import com.melongamesinc.workmatetestapp.data.mappers.toEntity
import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository

class CharacterRepositoryImpl(
    private val api: StarWarsApi,
    private val dao: CharacterDao
) : CharacterRepository {

    override suspend fun getCharacters(): List<Character> {
        try {
            val remoteData = api.getCharacters().results
            dao.insertCharacters(remoteData.map { it.toEntity() })
        } catch (e: Exception) { }
        return dao.getAllCharacters().map { it.toDomain() }
    }

    override suspend fun getCharactersById(id: String): Character {
        try {
            val remoteData = api.getCharacterById(id)
            dao.insertCharacters(listOf(remoteData.toEntity()))
        } catch (e: Exception) { }
        return dao.getCharacterById(id)?.toDomain()
            ?: throw Exception("Character not found in cache and network is unavailable")
    }

    override suspend fun searchCharacter(query: String): List<Character> {
        return try {
            val remoteData = api.searchCharacter(query).results
            dao.insertCharacters(remoteData.map { it.toEntity() })
            remoteData.map { it.toDomain() }
        } catch (e: Exception) {
            emptyList()
        }
    }
}