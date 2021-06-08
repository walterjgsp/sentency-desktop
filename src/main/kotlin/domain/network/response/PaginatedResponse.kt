package domain.network.response

import com.google.gson.annotations.SerializedName

data class PaginatedResponse<T>(
    @SerializedName("data") val data: List<T>,
    @SerializedName("page") val page: Int,
    @SerializedName("size") val size: Int,
    @SerializedName("prev") val prev: String? = null,
    @SerializedName("next") val next: String? = null
)
