package domain.sources

import domain.database.models.AuthorDB
import domain.database.models.QuoteDB
import domain.network.api.QuoteApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.runBlocking
import org.kodein.db.*
import ui.models.Author
import ui.models.Quote
import java.lang.RuntimeException

class QuoteDataSource(private val quoteApi: QuoteApi, private val db: DB) {

    suspend fun getHomeQuote(): Flow<Quote> = flow {
        emit(quoteApi.getRandomQuote().toHomeQuote())
    }

    suspend fun addToDB(quote: Quote) {
        val authorKey = db.put(
            AuthorDB(
                id = quote.author.id,
                name = quote.author.name,
                picUrl = quote.author.picUrl
            )
        )
        db.put(QuoteDB(quote.id, quote.message, authorKey))
    }

    suspend fun countQuotes(): Int {
        val cursor = db.find<QuoteDB>().all()
        val count = cursor.asModelSequence().count()
        cursor.close()
        return count
    }

    suspend fun deleteById(id: String) {
        val quote = db.keyById<QuoteDB>(id)
        db.delete(quote)
    }

    suspend fun getSavedQuotes(): List<Quote> {
        val cursor = db.find<QuoteDB>().all()
        val quotes = cursor.asModelSequence().toList().map { quote ->
            val authorDB: AuthorDB? = db[AuthorDB::class, quote.authorDB]
            authorDB?.let {
                val author = Author(it.id, it.name, it.picUrl)
                Quote(id = quote.id, message = quote.message, author = author)
            } ?: throw RuntimeException("Error when parsing quotes")
        }
        cursor.close()
        return quotes
    }
}
