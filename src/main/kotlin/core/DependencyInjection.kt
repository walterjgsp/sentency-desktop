package core

import domain.api.AuthorApi
import domain.api.QuoteApi
import domain.createRetrofit
import domain.provideApi
import domain.sources.AuthorDataSource
import domain.sources.QuoteDataSource
import org.koin.dsl.module
import ui.viewmodel.AuthorViewModel
import ui.viewmodel.HomeViewModel

val core = module {
    single { Config() }
}

val network = module {
    single { createRetrofit(get()) }
    single { provideApi<AuthorApi>(get()) }
    single { provideApi<QuoteApi>(get()) }
}

val viewModels = module {
    factory { AuthorViewModel(get()) }
    factory { HomeViewModel(get()) }
}

val sources = module {
    single { AuthorDataSource(get()) }
    single { QuoteDataSource(get()) }
}
