import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import core.*
import org.koin.core.context.GlobalContext.startKoin
import ui.components.Navigation
import ui.viewmodel.NavigationViewModel

fun main() = Window(
    title = "Sentency Desktop",
    resizable = false,
    size = IntSize(800, 800)
) {

    val navigationViewModel by injectComposed<NavigationViewModel>()

    initKoin()

    MaterialTheme {

        val selectedScreen by navigationViewModel.selectedScreen.collectAsState()

        Column(Modifier.fillMaxHeight()) {
            Box(modifier = Modifier.weight(3f)) {
                selectedScreen.screen()
            }
            Box {
                Navigation(navigationViewModel)
            }
        }
    }
}

private fun initKoin() {
    startKoin {
        printLogger()
        modules(core, network, database, viewModels, sources)
    }
}
