package ui.viewmodel

import domain.sources.QuoteDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ui.models.HomeQuote

class HomeViewModel(private val quoteDataSource: QuoteDataSource) : BaseViewModel() {

    val currentQuote: MutableStateFlow<HomeQuote?> = MutableStateFlow(null)

    init {
        nextQuote()
    }

    private suspend fun getQuote() {
        quoteDataSource.getHomeQuote().collect {
            currentQuote.value = it
            isLoading(false)
        }
    }

    fun saveQuote() {

    }

    fun nextQuote() {
        isLoading(true)
        scope.launch {
            delay(200)
            getQuote()
        }
    }
}
