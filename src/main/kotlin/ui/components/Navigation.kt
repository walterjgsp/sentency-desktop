package ui.components

import androidx.compose.foundation.layout.size
import androidx.compose.material.BottomNavigation
import androidx.compose.material.BottomNavigationItem
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.viewmodel.NavigationViewModel

@Composable
fun Navigation(navigationViewModel: NavigationViewModel) {

    val items = navigationViewModel.navigationMenu
    val selectedItem by navigationViewModel.selectedItem.collectAsState()

    BottomNavigation {
        items.forEachIndexed { index, item ->
            BottomNavigationItem(
                icon = { Icon(item.icon, contentDescription = null, modifier = Modifier.size(20.dp, 20.dp)) },
                label = { Text(item.text) },
                selected = selectedItem == index,
                onClick = { navigationViewModel.selectMenu(index) }
            )
        }
    }
}
