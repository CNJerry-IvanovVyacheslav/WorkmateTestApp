package com.melongamesinc.workmatetestapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melongamesinc.workmatetestapp.domain.models.Character
import com.melongamesinc.workmatetestapp.domain.models.Film
import com.melongamesinc.workmatetestapp.domain.models.Species
import com.melongamesinc.workmatetestapp.domain.usecases.GetCharacterByIdUseCase
import com.melongamesinc.workmatetestapp.domain.usecases.GetFilmByIdUseCase
import com.melongamesinc.workmatetestapp.domain.usecases.GetSpeciesByIdUseCase
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.async
import kotlinx.coroutines.awaitAll
import kotlinx.coroutines.coroutineScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

data class CharacterDetailState(
    val isLoading: Boolean = false,
    val character: Character? = null,
    val films: List<Film> = emptyList(),
    val species: List<Species> = emptyList(),
    val error: String? = null
)

@HiltViewModel
class CharacterDetailViewModel @Inject constructor(
    private val getCharacterByIdUseCase: GetCharacterByIdUseCase,
    private val getFilmByIdUseCase: GetFilmByIdUseCase,
    private val getSpeciesByIdUseCase: GetSpeciesByIdUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterDetailState())
    val state: StateFlow<CharacterDetailState> = _state.asStateFlow()

    fun loadCharacter(id: String) {
        viewModelScope.launch {
            _state.value = CharacterDetailState(isLoading = true)
            try {
                val character = getCharacterByIdUseCase(id)
                _state.value = CharacterDetailState(character = character, isLoading = true)

                coroutineScope {
                    val deferredFilms = character.films.map { filmUrl ->
                        async {
                            try {
                                val filmId = filmUrl.trimEnd('/').substringAfterLast('/')
                                getFilmByIdUseCase(filmId)
                            } catch (e: Exception) {
                                android.util.Log.e("DetailVM", "Film loading error: ${e.message}")
                                null
                            }
                        }
                    }

                    val deferredSpecies = character.species.map { speciesUrl ->
                        async {
                            try {
                                val speciesId = speciesUrl.trimEnd('/').substringAfterLast('/')
                                getSpeciesByIdUseCase(speciesId)
                            } catch (e: Exception) {
                                android.util.Log.e(
                                    "DetailVM",
                                    "Species loading error: ${e.message}"
                                )
                                null
                            }
                        }
                    }

                    val loadedFilms = deferredFilms.awaitAll().filterNotNull()
                    val loadedSpecies = deferredSpecies.awaitAll().filterNotNull()

                    _state.value = CharacterDetailState(
                        character = character,
                        films = loadedFilms,
                        species = loadedSpecies,
                        isLoading = false
                    )
                }
            } catch (e: Exception) {
                _state.value = CharacterDetailState(error = e.message ?: "Unknown error")
            }
        }
    }
}