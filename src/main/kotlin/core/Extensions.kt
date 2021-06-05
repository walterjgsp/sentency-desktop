package core

import org.koin.core.component.KoinComponent
import org.koin.core.component.inject

inline fun <reified T> injectComposed(): Lazy<T> = lazy {
    object : KoinComponent {
        val value: T by inject()
    }.value
}
