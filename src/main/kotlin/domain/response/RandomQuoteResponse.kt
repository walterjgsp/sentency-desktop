package domain.response

import com.google.gson.annotations.SerializedName
import ui.home.models.HomeQuote

data class RandomQuoteResponse(
    @SerializedName("quote") val quote: QuoteResponse,
    @SerializedName("author") val author: AuthorResponse
) {
    fun toHomeQuote() = HomeQuote(
        id = quote.id,
        message = quote.message,
        authorName = author.name
    )
}
