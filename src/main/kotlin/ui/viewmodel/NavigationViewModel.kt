package ui.viewmodel

import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.Database
import compose.icons.fontawesomeicons.solid.Home
import kotlinx.coroutines.flow.MutableStateFlow
import ui.models.NavigationItem
import ui.screen.BaseScreen
import ui.screen.HomeScreen
import ui.screen.MyQuotesScreen

class NavigationViewModel : BaseViewModel() {

    val navigationMenu: List<NavigationItem> = listOf(
        NavigationItem(text = "Home", icon = FontAwesomeIcons.Solid.Home, screen = HomeScreen()),
        NavigationItem(text = "Quotes", icon = FontAwesomeIcons.Solid.Database, screen = MyQuotesScreen())
    )

    val selectedItem: MutableStateFlow<Int> = MutableStateFlow(0)
    val selectedScreen: MutableStateFlow<BaseScreen> = MutableStateFlow(navigationMenu[0].screen)

    fun selectMenu(index: Int) {
        selectedItem.value = index
        selectedScreen.value = navigationMenu[index].screen
    }

}
