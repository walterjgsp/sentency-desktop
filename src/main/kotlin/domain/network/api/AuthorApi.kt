package domain.network.api

import domain.network.response.AuthorResponse
import domain.network.response.PaginatedResponse
import retrofit2.http.GET

interface AuthorApi {

    @GET("author/all")
    suspend fun getAllAuthors(): List<AuthorResponse>

    @GET("author")
    suspend fun getPaginatedAuthors(): PaginatedResponse<AuthorResponse>
}
