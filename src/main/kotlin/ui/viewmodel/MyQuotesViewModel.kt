package ui.viewmodel

import domain.sources.QuoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch
import ui.models.Author
import ui.models.Quote

class MyQuotesViewModel(private val quoteDataSource: QuoteDataSource) : BaseViewModel() {

    val savedQuotes: MutableStateFlow<List<Quote>> = MutableStateFlow(listOf())

    fun fetchSavedQuotes() {
        scope.launch {
            val quotes = quoteDataSource.getSavedQuotes()
            savedQuotes.value = quotes
        }
    }

    fun deleteQuote(quote: Quote) {
        scope.launch {
            quoteDataSource.deleteById(quote.id)
            with(savedQuotes.value) {
                savedQuotes.value = this.filter { it.id != quote.id }
            }
        }
    }
}
