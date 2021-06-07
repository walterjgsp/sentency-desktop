package domain.sources

import domain.api.AuthorApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import ui.models.Author

class AuthorDataSource(private val authorApi: AuthorApi) {

    suspend fun getAll(): Flow<List<Author>> = flow {
        emit(authorApi.getAllAuthors().map { it.toAuthor() })
    }

    suspend fun getPaginatedAuthors(): Flow<List<Author>> = flow {
        emit(authorApi.getPaginatedAuthors().data.map { it.toAuthor() })
    }
}
