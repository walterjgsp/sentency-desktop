package domain.database.models

import org.kodein.db.model.Id

data class AuthorDB(
    @Id val id: String,
    val name: String,
    val picUrl: String? = null,
)
