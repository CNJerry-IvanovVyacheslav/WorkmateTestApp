package com.melongamesinc.workmatetestapp.data.api

import com.melongamesinc.workmatetestapp.data.dto.CharacterDto
import com.melongamesinc.workmatetestapp.data.dto.CharacterListResponseDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {
    @GET("people/")
    suspend fun getCharacters() : CharacterListResponseDto

    @GET("people/{id}/")
    suspend fun getCharacterById(
        @Path("id") id: String
    ) : CharacterDto

    @GET("people/")
    suspend fun searchCharacter(
        @Query("search") name: String
    ): CharacterListResponseDto
}