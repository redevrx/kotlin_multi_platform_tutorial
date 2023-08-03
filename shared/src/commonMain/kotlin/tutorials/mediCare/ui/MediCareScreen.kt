package tutorials.mediCare.ui

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import dev.icerock.moko.mvvm.compose.getViewModel
import dev.icerock.moko.mvvm.compose.viewModelFactory
import tutorials.mediCare.domain.models.MediUIState
import tutorials.mediCare.ui.component.HomeScreen
import tutorials.mediCare.ui.component.LoginScreen
import tutorials.mediCare.ui.component.OnBoarding
import tutorials.mediCare.ui.component.RegisterScreen
import tutorials.mediCare.viewModel.MediCareViewModel

@Composable
fun MediCareScreen(){
    val viewModel = getViewModel(Unit, viewModelFactory { MediCareViewModel() })
    val uiState by viewModel.uiState.collectAsState()

    when(uiState){
        is MediUIState.OnBoarding ->{
            OnBoarding()
        }
        is MediUIState.LoginScreen ->{
            AnimatedVisibility(visible = uiState is MediUIState.LoginScreen
            ){
                LoginScreen(viewModel)
            }
        }
        is MediUIState.RegisterScreen ->{
            AnimatedVisibility(visible = uiState is MediUIState.RegisterScreen
            ){
                RegisterScreen(viewModel)
            }
        }
        is MediUIState.HomeScreen -> {
            HomeScreen(viewModel)
        }
        else ->{}
    }
}