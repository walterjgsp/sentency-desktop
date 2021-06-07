package ui.view

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.FloatingActionButton
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import compose.icons.FontAwesomeIcons
import compose.icons.fontawesomeicons.Solid
import compose.icons.fontawesomeicons.solid.ArrowRight
import compose.icons.fontawesomeicons.solid.Database
import ui.components.AuthorCard
import ui.theming.Purple500
import ui.viewmodel.HomeViewModel
import ui.theming.QuoteStyle

@Composable
fun HomeView(homeViewModel: HomeViewModel) {

    val currentQuote by homeViewModel.currentQuote.collectAsState()
    val loading by homeViewModel.loading.collectAsState()

    Crossfade(targetState = loading) { isLoading ->
        when (isLoading) {
            true -> LoadingView()
            else -> {
                currentQuote?.let { quote ->
                    Column(
                        modifier = Modifier.fillMaxHeight().fillMaxWidth(),
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally
                    ) {
                        Text(
                            "\"${quote.message}\"",
                            modifier = Modifier.padding(45.dp, 15.dp),
                            textAlign = TextAlign.Center,
                            style = QuoteStyle
                        )
                        AuthorCard(author = quote.author)
                        Spacer(Modifier.height(50.dp))
                        Row {
                            FloatingActionButton(
                                onClick = {
                                    homeViewModel.saveQuote()
                                },
                                modifier = Modifier.height(40.dp).width(40.dp),
                                backgroundColor = Purple500,
                                contentColor = Color.White,
                            ) {
                                Icon(
                                    FontAwesomeIcons.Solid.Database,
                                    "Save quote",
                                    modifier = Modifier.height(20.dp).width(20.dp)
                                )
                            }
                            Spacer(Modifier.width(10.dp))
                            FloatingActionButton(
                                onClick = {
                                    homeViewModel.nextQuote()
                                },
                                modifier = Modifier.height(40.dp).width(40.dp),
                                backgroundColor = Purple500,
                                contentColor = Color.White
                            ) {
                                Icon(
                                    FontAwesomeIcons.Solid.ArrowRight,
                                    "Next quote",
                                    modifier = Modifier.height(20.dp).width(20.dp)
                                )
                            }
                        }
                    }
                }
            }
        }
    }
}
