package ui.screen

import androidx.compose.animation.Crossfade
import androidx.compose.runtime.Composable

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.view.HomeView
import ui.view.LoadingView
import ui.viewmodel.HomeViewModel

class HomeScreen : BaseScreen, KoinComponent {

    private val homeViewModel: HomeViewModel by inject()

    @Composable
    override fun screen() {

        val loading by homeViewModel.loading.collectAsState()

        Crossfade(targetState = loading) { isLoading ->
            when (isLoading) {
                true -> LoadingView()
                else -> HomeView(homeViewModel)
            }
        }
    }
}

