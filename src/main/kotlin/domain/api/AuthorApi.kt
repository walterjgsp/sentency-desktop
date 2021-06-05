package domain.api

import domain.response.AuthorResponse
import domain.response.PaginatedResponse
import retrofit2.Retrofit
import retrofit2.http.GET

interface AuthorApi {

    @GET("author/all")
    suspend fun getAllAuthors(): List<AuthorResponse>

    @GET("author")
    suspend fun getPaginatedAuthors(): PaginatedResponse<AuthorResponse>
}
