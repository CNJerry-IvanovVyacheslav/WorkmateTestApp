package com.melongamesinc.workmatetestapp.domain.usecases

import com.melongamesinc.workmatetestapp.domain.models.Species
import com.melongamesinc.workmatetestapp.domain.repository.CharacterRepository
import javax.inject.Inject

class GetSpeciesByIdUseCase @Inject constructor(
    private val repository: CharacterRepository
) {
    suspend operator fun invoke(id: String): Species {
        return repository.getSpeciesById(id)
    }
}