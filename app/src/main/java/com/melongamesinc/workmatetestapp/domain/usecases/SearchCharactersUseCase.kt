package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository
import javax.inject.Inject

class SearchCharactersUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(query: String): List<Character> {
        return repository.searchCharacter(query)
    }
}