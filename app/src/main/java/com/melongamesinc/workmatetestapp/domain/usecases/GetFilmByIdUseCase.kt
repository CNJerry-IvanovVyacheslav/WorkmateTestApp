package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Film
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository
import javax.inject.Inject

class GetFilmByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: String): Film {
        return repository.getFilmById(id)
    }
}