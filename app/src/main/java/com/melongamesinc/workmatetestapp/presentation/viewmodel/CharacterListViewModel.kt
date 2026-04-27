package com.melongamesinc.workmatetestapp.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.melongamesinc.workmatetestapp.domain.usecases.GetCharactersUseCase
import com.melongamesinc.workmatetestapp.domain.usecases.SearchCharactersUseCase
import com.melongamesinc.workmatetestapp.presentation.character_list.CharacterListEvent
import com.melongamesinc.workmatetestapp.presentation.character_list.CharacterListState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Job
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class CharacterListViewModel @Inject constructor(
    private val getCharactersUseCase: GetCharactersUseCase,
    private val searchCharacterUseCase: SearchCharactersUseCase
) : ViewModel() {

    private val _state = MutableStateFlow(CharacterListState())
    val state = _state.asStateFlow()

    private var searchJob: Job? = null

    init {
        loadCharacters()
    }

    fun onEvent(event: CharacterListEvent) {
        when (event) {
            is CharacterListEvent.OnSearchQueryChanged -> {
                _state.update { it.copy(searchQuery = event.query) }

                searchJob?.cancel()
                searchJob = viewModelScope.launch {
                    delay(500L)
                    searchCharacters(event.query)
                }
            }

            CharacterListEvent.LoadCharacters -> {
                loadCharacters()
            }
        }
    }

    private fun loadCharacters() {
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val characters = getCharactersUseCase()
                _state.update { it.copy(isLoading = false, characters = characters) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = "Download error: ${e.message}") }
            }
        }
    }

    private fun searchCharacters(query: String) {
        if (query.isBlank()) {
            loadCharacters()
            return
        }
        viewModelScope.launch {
            _state.update { it.copy(isLoading = true, error = null) }
            try {
                val characters = searchCharacterUseCase(query)
                _state.update { it.copy(isLoading = false, characters = characters) }
            } catch (e: Exception) {
                _state.update { it.copy(isLoading = false, error = "Nothing was found") }
            }
        }
    }
}