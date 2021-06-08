package core

import domain.network.api.AuthorApi
import domain.network.api.QuoteApi
import domain.createRetrofit
import domain.database.createDB
import domain.provideApi
import domain.sources.AuthorDataSource
import domain.sources.QuoteDataSource
import org.koin.dsl.module
import ui.viewmodel.HomeViewModel
import ui.viewmodel.MyQuotesViewModel
import ui.viewmodel.NavigationViewModel

val core = module {
    single { Config() }
}

val network = module {
    single { createRetrofit(get()) }
    single { provideApi<AuthorApi>(get()) }
    single { provideApi<QuoteApi>(get()) }
}

val viewModels = module {
    factory { HomeViewModel(get()) }
    factory { NavigationViewModel() }
    factory { MyQuotesViewModel(get()) }
}

val sources = module {
    single { AuthorDataSource(get()) }
    single { QuoteDataSource(get(), get()) }
}

val database = module {
    single { createDB("sentency_desktop.db") }
}
