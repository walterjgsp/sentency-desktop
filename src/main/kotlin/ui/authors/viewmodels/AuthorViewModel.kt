package ui.authors.viewmodels

import domain.sources.AuthorDataSource
import kotlinx.coroutines.*
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.collect
import ui.authors.models.Author
import ui.shared.viewmodel.BaseViewModel

class AuthorViewModel(private val authorDataSource: AuthorDataSource) : BaseViewModel() {

    private val authorsList: MutableStateFlow<List<Author>> = MutableStateFlow(listOf())
    private var authorIndex = 0
    val currentAuthor: MutableStateFlow<Author?> = MutableStateFlow(null)

    init {
        scope.launch {
            fetchAuthors()
        }
    }

    private suspend fun fetchAuthors() {
        isLoading(true)
        authorDataSource.getAll().collect {
            authorsList.value = it
            isLoading(false)
            currentAuthor.value = authorsList.value[authorIndex]
        }
    }

    fun toggleAuthor() {
        authorIndex = (authorIndex + 1) % authorsList.value.size
        currentAuthor.value = authorsList.value[authorIndex]
    }

}
