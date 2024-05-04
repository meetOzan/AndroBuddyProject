package com.mertozan.androbuddyproject.presentation.home

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mertozan.androbuddyproject.common.ResponseState
import com.mertozan.androbuddyproject.data.model.ValorantModel
import com.mertozan.androbuddyproject.data.repository.ValorantRepository
import kotlinx.coroutines.launch

class HomeViewModel : ViewModel() {

    private val _homeUiState = MutableLiveData(HomeUiState())
    val homeUiState: LiveData<HomeUiState> get() = _homeUiState

    init {
        getCharacterList()
    }

    private fun getCharacterList() {
        viewModelScope.launch {
            ValorantRepository().getAllCharacter().collect { responseState ->
                when (responseState) {
                    is ResponseState.Error -> {
                        _homeUiState.postValue(
                            HomeUiState(
                                isLoading = false,
                                isError = true,
                                errorMessage = responseState.message
                            )
                        )
                    }

                    ResponseState.Loading -> {
                        _homeUiState.postValue(
                            HomeUiState(
                                isLoading = true
                            )
                        )
                    }

                    is ResponseState.Success -> {
                        _homeUiState.postValue(
                            HomeUiState(
                                isLoading = false,
                                isError = false,
                                characterList = responseState.data
                            )
                        )
                    }
                }
            }
        }
    }
}

data class HomeUiState(
    val isLoading: Boolean = false,
    val isError: Boolean = false,
    val errorMessage: String = "",
    val characterList: List<ValorantModel> = emptyList()
)