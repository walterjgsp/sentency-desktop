package domain.response

import com.google.gson.annotations.SerializedName

data class QuoteResponse(
    @SerializedName("id") val id: String,
    @SerializedName("message") val message: String,
    @SerializedName("authorId") val authorId: String,
    @SerializedName("timestamp") val timestamp: Long
)
