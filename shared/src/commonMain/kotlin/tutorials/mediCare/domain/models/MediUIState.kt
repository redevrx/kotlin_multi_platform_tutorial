package tutorials.mediCare.domain.models

import kotlinx.serialization.Serializable

sealed interface MediUIState {
    data object OnBoarding:MediUIState
    data object LoginScreen:MediUIState
    data object RegisterScreen:MediUIState
    data object HomeScreen:MediUIState
}