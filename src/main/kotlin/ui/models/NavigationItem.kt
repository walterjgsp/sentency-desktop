package ui.models

import androidx.compose.ui.graphics.vector.ImageVector
import ui.screen.BaseScreen

data class NavigationItem(
    val text: String,
    val icon: ImageVector,
    val screen: BaseScreen
)
