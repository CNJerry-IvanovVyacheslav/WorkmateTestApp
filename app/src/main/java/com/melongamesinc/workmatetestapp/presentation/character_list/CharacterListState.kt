package com.melongamesinc.workmatetestapp.presentation.character_list

import com.melongamesinc.workmatetestapp.domain.models.Character

data class CharacterListState(
    val isLoading: Boolean = false,
    val characters: List<Character> = emptyList(),
    val error: String? = null,
    val searchQuery: String = ""
)
