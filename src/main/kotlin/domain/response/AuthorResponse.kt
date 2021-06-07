package domain.response

import com.google.gson.annotations.SerializedName
import ui.models.Author

data class AuthorResponse(
    @SerializedName("id") val id: String,
    @SerializedName("name") val name: String,
    @SerializedName("picUrl") val picUrl: String? = null
) {
    fun toAuthor(): Author = Author(id, name, picUrl = picUrl)
}
