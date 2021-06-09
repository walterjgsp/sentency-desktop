package ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject
import ui.components.QuoteCard
import ui.viewmodel.MyQuotesViewModel

class MyQuotesScreen : BaseScreen, KoinComponent {

    private val myQuotesViewModel: MyQuotesViewModel by inject()

    @Composable
    override fun screen() {

        myQuotesViewModel.fetchSavedQuotes()
        val quotes by myQuotesViewModel.savedQuotes.collectAsState()

        Column(
            modifier = Modifier.fillMaxSize(),
        ) {
            LazyColumn(
                contentPadding = PaddingValues(horizontal = 16.dp, vertical = 8.dp),
                verticalArrangement = Arrangement.spacedBy(10.dp)
            ) {
                items(quotes) { quote ->
                    QuoteCard(quote) {
                        myQuotesViewModel.deleteQuote(quote)
                    }
                }
            }
        }
    }
}
