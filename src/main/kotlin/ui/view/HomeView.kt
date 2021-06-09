package ui.view

import androidx.compose.foundation.layout.*
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Star
import ui.components.AuthorCard
import ui.theming.Purple500
import ui.viewmodel.HomeViewModel
import ui.theming.quoteStyle

@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    val currentQuote by homeViewModel.currentQuote.collectAsState()
    val snackbarHostState by homeViewModel.snackbarHostState.collectAsState()

    currentQuote?.let { quote ->
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Text(
                "\"${quote.message}\"",
                modifier = Modifier.padding(45.dp, 15.dp),
                textAlign = TextAlign.Center,
                style = quoteStyle(45)
            )
            AuthorCard(author = quote.author)
            Spacer(Modifier.height(50.dp))
            Row {
                FloatingActionButton(
                    onClick = {
                        homeViewModel.saveQuote()
                    },
                    modifier = Modifier.size(40.dp, 40.dp),
                    backgroundColor = Purple500,
                    contentColor = Color.White,
                ) {
                    Icon(
                        FontAwesomeIcons.Solid.Star,
                        "Save quote",
                        modifier = Modifier.size(20.dp, 20.dp),
                    )
                }
                Spacer(Modifier.width(10.dp))
                FloatingActionButton(
                    onClick = {
                        homeViewModel.nextQuote()
                    },
                    modifier = Modifier.size(40.dp, 40.dp),
                    backgroundColor = Purple500,
                    contentColor = Color.White
                ) {
                    Icon(
                        FontAwesomeIcons.Solid.ArrowRight,
                        "Next quote",
                        modifier = Modifier.size(20.dp, 20.dp),
                    )
                }
            }
        }

        Box(modifier = Modifier.fillMaxSize()) {
            SnackbarHost(
                hostState = snackbarHostState,
                modifier = Modifier.align(Alignment.BottomCenter),
                snackbar = {
                    Snackbar(modifier = Modifier.width(350.dp)) { Text(it.message) }
                }
            )
        }

    }
}

