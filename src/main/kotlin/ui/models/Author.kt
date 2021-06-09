package ui.models

import androidx.compose.ui.graphics.ImageBitmap
import androidx.compose.ui.graphics.imageFromResource
import core.loadPicture
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.SupervisorJob
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch


data class Author(
    val id: String,
    val name: String,
    val picUrl: String? = null,
) {
    var pic: MutableStateFlow<ImageBitmap> = MutableStateFlow(imageFromResource("images/profile.png"))
        private set

    private val scope: CoroutineScope = CoroutineScope(Dispatchers.Unconfined + SupervisorJob())

    init {
        scope.launch {
            picUrl?.loadPicture()?.let {
                pic.value = it
            }
        }
    }
}
