package ui.viewmodel

import androidx.compose.material.SnackbarDuration
import androidx.compose.material.SnackbarHostState
import domain.sources.QuoteDataSource
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch
import ui.models.Quote

class HomeViewModel(private val quoteDataSource: QuoteDataSource) : BaseViewModel() {

    val currentQuote: MutableStateFlow<Quote?> = MutableStateFlow(null)
    val snackbarHostState: MutableStateFlow<SnackbarHostState> = MutableStateFlow(SnackbarHostState())

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
        scope.launch {
            currentQuote.value?.let {
                quoteDataSource.addToDB(it)
                snackbarHostState.value.showSnackbar(
                    "Quote saved on database",
                    actionLabel = null,
                    duration = SnackbarDuration.Short
                )
            }
        }
    }

    fun nextQuote() {
        isLoading(true)
        scope.launch {
            delay(200)
            getQuote()
        }
    }
}
