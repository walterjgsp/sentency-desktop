package domain.api

import domain.response.QuoteResponse
import retrofit2.http.GET

interface QuoteApi {

    @GET("quote/random")
    suspend fun getRandomQuote(): QuoteResponse
}
