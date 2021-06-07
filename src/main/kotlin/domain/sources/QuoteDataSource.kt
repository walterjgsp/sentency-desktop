package domain.sources

import domain.api.QuoteApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ui.models.HomeQuote

class QuoteDataSource(private val quoteApi: QuoteApi) {

    suspend fun getHomeQuote(): Flow<HomeQuote> = flow {
        emit(quoteApi.getRandomQuote().toHomeQuote())
    }
}
