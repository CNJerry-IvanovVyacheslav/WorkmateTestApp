package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository

class GetCharacterByIdUseCase(private val repository: CharacterRepository) {

    suspend operator fun invoke(id: String) : Character {
        return repository.getCharactersById(id)
    }
}