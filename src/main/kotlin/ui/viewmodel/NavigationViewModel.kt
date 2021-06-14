package ui.viewmodel

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import kotlinx.coroutines.flow.MutableStateFlow
import ui.models.NavigationItem
import ui.screen.BaseScreen
import ui.screen.HomeScreen
import ui.screen.MyQuotesScreen

class NavigationViewModel : BaseViewModel() {

    val navigationMenu: List<NavigationItem> = listOf(
        NavigationItem(text = "Home", icon = Icons.Default.Home, screen = HomeScreen()),
        NavigationItem(text = "Quotes", icon = Icons.Default.List, screen = MyQuotesScreen())
    )

    val selectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedScreen: MutableStateFlow<BaseScreen> = MutableStateFlow(navigationMenu[0].screen)

    fun selectMenu(index: Int) {
        selectedItem.value = index
        selectedScreen.value = navigationMenu[index].screen
    }

}
