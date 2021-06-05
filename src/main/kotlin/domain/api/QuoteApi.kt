package domain.api

import domain.response.RandomQuoteResponse
import retrofit2.http.GET

interface QuoteApi {

    @GET("quote/random")
    suspend fun getRandomQuote(): RandomQuoteResponse
}
