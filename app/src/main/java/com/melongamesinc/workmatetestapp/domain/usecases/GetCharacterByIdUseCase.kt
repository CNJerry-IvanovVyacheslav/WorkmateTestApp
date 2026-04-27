package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository
import javax.inject.Inject // <--- НЕ ЗАБУДЬ ЭТОТ ИМПОРТ

class GetCharacterByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: String): Character {
        return repository.getCharactersById(id)
    }
}