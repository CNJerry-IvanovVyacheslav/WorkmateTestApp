package com.melongamesinc.workmatetestapp.data.api

import com.melongamesinc.workmatetestapp.data.dto.CharacterDto
import com.melongamesinc.workmatetestapp.data.dto.CharacterListResponseDto
import com.melongamesinc.workmatetestapp.data.dto.FilmDto
import com.melongamesinc.workmatetestapp.data.dto.SpeciesDto
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface StarWarsApi {
    @GET("people/")
    suspend fun getCharacters(): CharacterListResponseDto

    @GET("people/{id}/")
    suspend fun getCharacterById(
        @Path("id") id: String
    ): CharacterDto

    @GET("people/")
    suspend fun searchCharacter(
        @Query("search") name: String
    ): CharacterListResponseDto

    @GET("films/{id}/")
    suspend fun getFilmById(@Path("id") id: String): FilmDto

    @GET("species/{id}/")
    suspend fun getSpeciesById(@Path("id") id: String): SpeciesDto
}