package ui.viewmodel

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow

abstract class BaseViewModel {

    val loading: MutableStateFlow<Boolean> = MutableStateFlow(false)
    protected val scope: CoroutineScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())

    protected fun isLoading(load: Boolean) {
        loading.value = load
    }
}
