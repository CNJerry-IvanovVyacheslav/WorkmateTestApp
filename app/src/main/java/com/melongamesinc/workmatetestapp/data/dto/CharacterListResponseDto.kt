package com.melongamesinc.workmatetestapp.data.dto

import kotlinx.serialization.Serializable

@Serializable
data class CharacterListResponseDto(
    val results: List<CharacterDto>
)
