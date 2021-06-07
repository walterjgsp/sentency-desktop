package domain.response

import com.google.gson.annotations.SerializedName
import ui.models.HomeQuote

data class QuoteResponse(
    @SerializedName("id") val id: String,
    @SerializedName("message") val message: String,
    @SerializedName("authorId") val authorId: String,
    @SerializedName("timestamp") val timestamp: Long,
    @SerializedName("author") val author: AuthorResponse
) {
    fun toHomeQuote(): HomeQuote = HomeQuote(id, author.toAuthor(), message)
}
