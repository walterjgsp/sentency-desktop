package ui.screen

import androidx.compose.runtime.Composable
import core.injectComposed
import ui.view.HomeView
import ui.viewmodel.HomeViewModel

@Composable
fun HomeScreen() {

    val homeViewModel by injectComposed<HomeViewModel>()

    HomeView(homeViewModel)
}
