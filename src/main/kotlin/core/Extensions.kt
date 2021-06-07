package core

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.asImageBitmap
import io.ktor.client.*
import io.ktor.client.engine.cio.*
import io.ktor.client.request.*
import org.jetbrains.skija.Image
import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <reified T> injectComposed(): Lazy<T> = lazy {
    object : KoinComponent {
        val value: T by inject()
    }.value
}

suspend fun String.loadPicture(): ImageBitmap {
    val ktorHttpClient = HttpClient(CIO)

    val image = ktorHttpClient.use { client ->
        client.get<ByteArray>(this)
    }
    return Image.makeFromEncoded(image).asImageBitmap()
}
