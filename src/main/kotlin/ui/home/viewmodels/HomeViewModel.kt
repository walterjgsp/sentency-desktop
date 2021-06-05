package ui.home.viewmodels

import domain.sources.QuoteDataSource
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ui.home.models.HomeQuote
import ui.shared.viewmodel.BaseViewModel

class HomeViewModel(private val quoteDataSource: QuoteDataSource) : BaseViewModel() {

    val currentQuote: MutableStateFlow<HomeQuote?> = MutableStateFlow(null)

    init {
        nextQuote()
    }

    private suspend fun getQuote() {
        isLoading(true)
        quoteDataSource.getHomeQuote().collect {
            currentQuote.value = it
            isLoading(false)
        }
    }


    fun nextQuote() {
        scope.launch {
            getQuote()
        }
    }
}
