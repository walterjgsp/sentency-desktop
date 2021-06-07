import androidx.compose.animation.Crossfade
import androidx.compose.desktop.Window
import androidx.compose.material.MaterialTheme
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import core.*
import org.koin.core.context.GlobalContext.startKoin
import ui.screen.HomeScreen

fun main() = Window(title = "Sentency Desktop") {

    initKoin()

    MaterialTheme {
        HomeScreen()
    }
}

private fun initKoin() {
    startKoin {
        printLogger()
        modules(core, network, viewModels, sources)
    }
}
