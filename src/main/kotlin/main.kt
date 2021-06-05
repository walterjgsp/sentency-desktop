import androidx.compose.desktop.Window
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.MaterialTheme
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.IntSize
import androidx.compose.ui.unit.dp
import core.*
import org.koin.core.context.GlobalContext.startKoin
import ui.authors.AuthorsView
import ui.authors.viewmodels.AuthorViewModel
import ui.home.view.HomeView
import ui.home.viewmodels.HomeViewModel

fun main() = Window(title = "Sentency Desktop") {

    initKoin()

    val homeViewModel by injectComposed<HomeViewModel>()

    MaterialTheme {
        HomeView(homeViewModel)
    }
}

private fun initKoin() {
    startKoin {
        printLogger()
        modules(core, network, viewModels, sources)
    }
}
