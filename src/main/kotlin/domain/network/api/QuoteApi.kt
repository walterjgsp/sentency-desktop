package domain.network.api

import domain.network.response.QuoteResponse
import retrofit2.http.GET

interface QuoteApi {

    @GET("quote/random")
    suspend fun getRandomQuote(): QuoteResponse
}
