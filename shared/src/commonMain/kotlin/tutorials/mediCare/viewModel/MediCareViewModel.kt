package tutorials.mediCare.viewModel

import dev.icerock.moko.mvvm.viewmodel.ViewModel
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import tutorials.mediCare.domain.models.MediUIState
import tutorials.mediCare.domain.models.MediUIState.*


class MediCareViewModel:ViewModel() {
    private val _uiState = MutableStateFlow<MediUIState>(OnBoarding)
    val uiState get() = _uiState.asStateFlow()

    init {
        loadingScreen()
    }

    private fun loadingScreen() = viewModelScope.launch {
        delay(3000L)
        _uiState.update { LoginScreen }
    }

    fun toRegisterScreen() = viewModelScope.launch {
        _uiState.update { RegisterScreen }
    }

    fun toLoginScreen() = viewModelScope.launch {
        _uiState.update { LoginScreen }
    }

    fun toHomeScreen() = viewModelScope.launch {
        _uiState.update { HomeScreen }
    }
}