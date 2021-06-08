package domain.database.models

import org.kodein.db.Key
import org.kodein.db.model.Id

data class QuoteDB(
    @Id val id: String,
    val message: String,
    val authorDB: Key<AuthorDB>
)
