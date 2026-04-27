package com.melongamesinc.workmatetestapp.presentation.character_list

sealed interface CharacterListEvent {
    data class OnSearchQueryChanged(val query: String) : CharacterListEvent
    object LoadCharacters : CharacterListEvent
}