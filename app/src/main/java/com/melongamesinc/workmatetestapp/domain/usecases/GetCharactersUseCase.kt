package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository

class GetCharactersUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke() : List<Character> {
        return repository.getCharacters()
    }
}