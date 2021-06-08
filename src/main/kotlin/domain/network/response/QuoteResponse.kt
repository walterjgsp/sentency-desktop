package domain.network.response

import com.google.gson.annotations.SerializedName
import ui.models.Quote

data class QuoteResponse(
    @SerializedName("id") val id: String,
    @SerializedName("message") val message: String,
    @SerializedName("authorId") val authorId: String,
    @SerializedName("timestamp") val timestamp: Long,
    @SerializedName("author") val author: AuthorResponse
) {
    fun toHomeQuote(): Quote = Quote(id, author.toAuthor(), message)
}
