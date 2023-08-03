import androidx.compose.runtime.Composable
import screen.shopUI.ShopScreen
import theme.RedevRxTheme
import tutorials.mediCare.ui.MediCareScreen

@Composable
fun App() {
    RedevRxTheme {
       MediCareScreen()
    }
}

expect fun getPlatformName(): String